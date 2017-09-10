import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * Controller ���� ���
 * 
 * @author Kyung
 *
 */
public class MemoMain {
	Model model = new Model();
	View view = new View();
	
	public static void main(String args[]) {
		// �Է��� �޾Ƽ� ó���ϴ� ����
		Scanner scanner = new Scanner(System.in);
		MemoMain main = new MemoMain();
		
		// Ű���� �Է��߿� EnterŰ�� �Էµɶ����� ���
		//String test = scanner.nextLine(); 
		//System.out.println(test);
		
		String command = "";		
		while(!command.equals("exit")) {
			
			// ��ɾ �Է¹޾Ƽ� �ļ�ó��
			// c - create : ������ �Է¸��� ��ȯ
			// r - read : ������ �б���� ��ȯ
			// u - update : ������ �������� ��ȯ
			// d - delete : ������ �������� ��ȯ
			main.view.println("------------��ɾ �Է��ϼ���-------------");
			main.view.println("c : ����, r : �б�, u : ����, d : ����, l : ���");
			main.view.println("exit : ����");
			main.view.println("--------------------------------------");
			command = scanner.nextLine();
			
			// ��ɾ �б�ó��
			switch(command) {
			case "c":
				Memo cMemo = main.view.create(scanner);				
				main.model.create(cMemo);
				break;
			case "r":
				String rTempNo = main.view.findNo(scanner);
				// ------ ���ڰ� �Էµ��� �ʾ��� ���� ���� ó�� ------//
				try {
					int no = Integer.parseInt(rTempNo);
					//Model���� no�� �޾� �����͸� �ҷ��´�.
					Memo rMemo = main.model.read(no);
					
					//no�� ���� ��� �޼����� �����ش�.
					if(rMemo == null) {
						main.view.message(0);
					} else {
						// ������ memo�� ȭ�鿡 �����ش�.
						main.view.read(rMemo);
					}
				} catch(NumberFormatException e) {
					main.view.message(1);
				}				
				break;
			case "u":
				String uTempNo = main.view.findNo(scanner);
				// ------ ���ڰ� �Էµ��� �ʾ��� ���� ���� ó�� ------//
				try {
					int no = Integer.parseInt(uTempNo);
					//Model���� no�� �޾� �����͸� �ҷ��´�.
					Memo uMemo = main.model.read(no);
					
					//no�� ���� ��� �޼����� �����ش�.
					if(uMemo ==null) {
						main.view.message(0);
					} else {
						// �������� ���������� �޴´�.
						uMemo = main.view.update(uMemo,scanner);
						// ���������� Model�� �����ϰ� ���� �ϷῩ�θ� �޾ƿ´�.
						boolean updateCheck = main.model.update(no, uMemo);
						// ������ �ϷῩ�θ� ����ڿ��� �˸���.
						main.view.update(updateCheck);
					}
				} catch(NumberFormatException e) {
					main.view.message(1);
				}		
				break;
			case "d":
				String dTempNo = main.view.findNo(scanner);
				// ------ ���ڰ� �Էµ��� �ʾ��� ���� ���� ó�� ------//
				try {
					int no = Integer.parseInt(dTempNo);
					//Model���� no�� �޾� �����͸� �ҷ��´�.
					Memo dMemo = main.model.read(no);
					
					//no�� ���� ��� �޼����� �����ش�.
					if(dMemo ==null) {
						main.view.message(0);
					} else {
						// ������ memo�� �����ϰ� �Ϸ� ���θ� �˸���.
						boolean deleteCheck = main.model.delete(no);
						// ������ �������θ� ����ڿ��� �˸���.
						main.view.delete(deleteCheck);
					}
				} catch(NumberFormatException e) {
					main.view.message(1);
				}
				break;
			case "l":
				//��ü �����͸� Model�� ���� �޾ƿ´�.
				ArrayList<Memo> memoList = main.model.showList();
				//�޾ƿ� �����͸� View�� �����ش�.
				main.view.showList(memoList);
				break;
			}
		}
		main.view.message(100);

	}
}
