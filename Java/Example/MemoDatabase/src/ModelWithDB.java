import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;


public class ModelWithDB {

	private static final String url ="jdbc:mysql://localhost:3306/memo"; //�߰��� �����ͺ��̽� �̸��� ���־�� �Ѵ�.
	private static final String ID = "root";
	private static final String PW = "mysql";
	Connection con = null;
	
	// ������
	public ModelWithDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //����̹��� �������� �ε�
		} catch (Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}
	
	// create
	public void create(Memo memo) {
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(url, ID, PW)) { // �����ͺ��̽� �ڵ� ���� ����	
			// 2. ������ ����
			// 2.1 ���� ����
			String query = " insert into memo(name, content, datetime)"
							+ " values(?, ?, ?)";
			// 2.2 ������ ���� ������ ���·� ������ش�.
			PreparedStatement pstmt = con.prepareStatement(query);
			// 2.3 ����ǥ�� ���� ����
			pstmt.setString(1, memo.name);
			pstmt.setString(2, memo.content);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			// 2.4 ������ ����
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		} // 3. ������ ���̽� ���� ����
	}
	
	// read
	public Memo read(int no) {
		Memo memo = new Memo();
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(url, ID, PW)) { // �����ͺ��̽� �ڵ� ���� ����	
			// 2. ������ ����
			// 2.1 ���� ����
			String query = "select * from memo where no ="+no;
			// 2.2 ������ ������ ���� ������ ���·� ������ش�.
			Statement stmt = con.createStatement();
			// 2.3 select�� ������� �����ޱ� ���� ������ ����
			ResultSet rs = stmt.executeQuery(query);
			//rs���� iterator�� �̹� ������
			//������� �ݺ��ϸ鼭 �ϳ��� ���� �� �ִ�.
			if(rs.next()) {
				memo.no = rs.getInt("no");
				memo.name = rs.getString("name");
				memo.content = rs.getString("content");
				memo.datetime = rs.getLong("datetime");
				// �޸� Ŭ������ ���� ����
			}
			if(memo.no==0) {
				return null;
			}
		} catch (Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		return memo;
	}
	
	// update
	public boolean update(int no, Memo memoTemp) {	
		boolean check=false;
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(url,ID,PW)){
			//2. ������ ����
			String query = "update memo set name = ?, content = ? where no = ?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, memoTemp.name);
			psmt.setString(2, memoTemp.content);
			psmt.setInt(3, no);
			psmt.executeUpdate();
			
			check = true;
		} catch(Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		return check;
	}
	
	//delete
	public boolean delete(int no) {
		boolean check = false;
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(url,ID,PW)){
			//2. ������ ����
			String query = "delete from memo where no = ?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, no);
			psmt.executeUpdate();
			
			check=true;
		} catch(Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		return check;
	}
	
	// showList : ����� ������ 
	public ArrayList<Memo> showList(){
		ArrayList<Memo> list = new ArrayList<>();
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(url, ID, PW)) { // �����ͺ��̽� �ڵ� ���� ����	
			// 2. ������ ����
			String query = "select * from memo";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Memo memo = new Memo();
				memo.no = rs.getInt("no");
				memo.name = rs.getString("name");
				memo.content = rs.getString("content");
				memo.datetime = rs.getLong("datetime");
				// �޸� Ŭ������ ���� ����
				list.add(memo);
			}
		} catch (Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		return list;
	}
}
