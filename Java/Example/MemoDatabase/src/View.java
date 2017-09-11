import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
	// Ű���� �Է��� �޴� �Լ�
			public Memo create(Scanner scanner) {
				// �� �ϳ��� �����ϱ� ���� �޸� ���� Ȯ��
				Memo memo = new Memo();
				
				println("�̸��� �Է��ϼ��� : ");
				memo.name = scanner.nextLine();
				println("������ �Է��ϼ��� : ");
				memo.content = scanner.nextLine();
				
				// ��¥�� �ڵ����� �Է�(�ý��� �ð�)
				memo.datetime = System.currentTimeMillis();
				
				return memo;
			}
			
			public void read(Memo memo) {
				// �Է¹��� �޸� ����� �� ���
				println("No: "+memo.no);
				println("Author: "+memo.name);
				println("Content: "+memo.content);
				
				//���ڷ� �Է¹��� ��¥���� ���� ��¥�� ����
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String formattedDate = sdf.format(memo.datetime);
				println(formattedDate);		
			}
			//���ο� �޸� ����
			public Memo update(Memo memo, Scanner scanner) {
				
				Memo memoTemp = new Memo();
				// ������Ʈ �� ���� ���ο� �޸𸮿� ����
				println("�̸��� �Է����ּ���: ");
				memo.name = scanner.nextLine();
				println("������ �Է����ּ���: ");
				memo.content = scanner.nextLine();
				memoTemp = memo;

				return memoTemp;
			}
			//update���� üũ
			public void update(boolean check) {
				if(check==true) {
					println("�޸� ���������� �����Ǿ����ϴ�");
				} else {
					println("�޸� ������ �����Ͽ����ϴ�.");
				}
			}
			
			//delete ���� üũ
			public void delete(boolean check) {
				if(check==true) {
					println("�޸� ���������� �����Ǿ����ϴ�");
				} else {
					println("�޸� ������ �����Ͽ����ϴ�.");
				}
			}
			
			public void showList(ArrayList<Memo> memoList) {
				// ArrayList ����Ҹ� �ݺ����� ���鼭 ���پ� ���
				for (Memo memo : memoList) {
					print("No: "+memo.no);
					print(" | Author: "+memo.name);
					println(" | Content: "+memo.content);
				}
			}
			
			public void print(String string) {
				System.out.print(string);
			}
			
			public void println(String string) {
				System.out.println(string);
			}
			
			// �۹�ȣ�� �Է¹޾� ����
			public String findNo(Scanner scanner){
				println("�� ��ȣ�� �Է��ϼ���");
				String tempNo = scanner.nextLine();
				return tempNo;		
			}
			
			// Ư�� ��ȣ�� �°� �޽��� ����
			public void message(int num) {
				if(num==0) {
					println("�Է��� �� ��ȣ�� �������� �ʽ��ϴ�");
				} else if(num==1) {
					println("���ڸ� �Է��� �ּ���.");
				} else if(num==100) {
					println("�ý����� ����Ǿ����ϴ�");
				}
			}
}
