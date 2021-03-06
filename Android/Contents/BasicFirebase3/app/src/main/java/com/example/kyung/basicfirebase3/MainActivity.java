package com.example.kyung.basicfirebase3;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText editEmail;
    EditText editPassword;
    EditText signEmail;
    EditText signPassword;

    TextView infoEmail;
    TextView infoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        initView();
    }

    private void initView(){
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        signEmail = findViewById(R.id.signEmail);
        signPassword = findViewById(R.id.signPassword);

        infoEmail = findViewById(R.id.infoEmail);
        infoPassword = findViewById(R.id.infoPassword);
    }

    @Override
    public void onStart() {
        super.onStart();
        // 이미 로그인 되어있으면 사용자를 파이어베이스에서 가져온다.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }

    // 사용자 등록
    public void signup(View view){
        // @ 하나, . 하나 필수, "영문" "숫자" "_" "-" 허용
        String email = editEmail.getText().toString();
        // 특수문자 하나 이상 "!, @, #, $, %, ^, &, *, (, )" 들어감 => 바꾸면 안됨
        // 영문, 숫자
        String password = editPassword.getText().toString();

        // validation check (by 정규식)
        if(!isValidEmail(email) || !isValidPassword(password)){
            if(!isValidEmail(email) && !isValidPassword(password)) {
                infoEmail.setText("이메일 형식이 잘못되었습니다.");
                infoEmail.setVisibility(View.VISIBLE);
                infoPassword.setText("비밀번호 형식이 잘못되었습니다.");
                infoPassword.setVisibility(View.VISIBLE);
            }
            if(!isValidEmail(email) && isValidPassword(password)){
                infoEmail.setText("이메일 형식이 잘못되었습니다.");
                infoEmail.setVisibility(View.VISIBLE);
                infoPassword.setVisibility(View.INVISIBLE);
            }
            if(isValidEmail(email) && !isValidPassword(password)){
                infoEmail.setVisibility(View.INVISIBLE);
                infoPassword.setText("비밀번호 형식이 잘못되었습니다.");
                infoPassword.setVisibility(View.VISIBLE);
            }
            return;
        }
        infoEmail.setVisibility(View.INVISIBLE);
        infoPassword.setVisibility(View.INVISIBLE);

        // 파이어베이스의 인증모듈로 사용자를 생성
        mAuth.createUserWithEmailAndPassword(email, password)
                // 완료확인 리스너
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            // 이메일 유효성을 확인하기 위해 해당 이메일로 메일이 발송된다.
                            user.sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            // 원래는 다음 엑티비티로 이동시킴
                                            Toast.makeText(MainActivity.this ,"이메일을 발송하였습니다. 확인해주세요", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean isValidEmail(String email){
        boolean err = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches()){
            err = true;
        }
        return err;
    }

    private boolean isValidPassword(String password){
        boolean err = false;
        // 영문자와 숫자만 허용
        String regex = "^[A-Za-z0-9]{8,}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        if(m.matches()) {
            err = true;
        }
        return err;
    }

    // 사용자 로그인
    public void signin(View view){
        String email = signEmail.getText().toString();
        String password = signPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            // 이메일 검증 확인
                            if(user.isEmailVerified()){
                                // 다음 페이지로 이동
                                Intent intent = new Intent(MainActivity.this, StorageActivity.class);
                                startActivity(intent);
                                // 항상 로그인 후에는 엑티비티를 종료시켜야 한다.
                                finish();
                            } else{
                                Toast.makeText(MainActivity.this, "이메일을 확인하셔야 합니다.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void getUserInfo(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // 이메일 검증이 완료되었는지 확인
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
        }
    }
}
