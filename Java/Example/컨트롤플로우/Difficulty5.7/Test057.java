/**
 * 
 * Controlflow ���̵�5.7 ���� Ǯ��
 * mark���� ���� �Է°� lines �Է�
 * 
 * @author Kyung
 * 
 *
 */
public class Test057 {
	
	public void run(String mark, int lines) {
		
		//ù�� ���
		for(int firstIndex=0 ; firstIndex<lines*2-1 ; firstIndex++) {
			System.out.print(mark);
		}
		System.out.println("");
		
		//��� ���
		for(int middleLine=0; middleLine<lines*2-3 ; middleLine++) {
			System.out.print(mark);
			
			for(int middleSpaceIndex=0; middleSpaceIndex<lines*2-3 ; middleSpaceIndex++) {
				System.out.printf(" ");
			}
			System.out.println(mark);
		}
		
		//������ ���
		for(int finalIndex=0 ; finalIndex<lines*2-1 ; finalIndex++) {
			System.out.print(mark);
		}
	}

}
