
/**
 * 
 * @author Kyung
 * Controlflow ���̵�3.6 ���� Ǯ��
 *
 */
public class Test036 {
	
	public void run(String mark, int lines) {
		
		//���μ� ��ŭ �ݺ�
		for(int index=0 ; index<lines-1 ; index=index+1) {
			
			// ���� ���� ǥ��
			for(int innerSpaceIndex=0 ; innerSpaceIndex < lines-index-1 ; innerSpaceIndex++) {				
				System.out.print(" ");
			}
			
			//���� �� mark
			System.out.print(mark);
			
			//��� ���� ǥ��
			for(int innerMarkIndex=0 ; innerMarkIndex<index*2-1 ; innerMarkIndex++) {
				System.out.print(" ");
			}
			
			//������ �� mark
			if(index==0) {
				System.out.println("");
			} else {
				System.out.println(mark);				
			}			
		}
		
		//������ ���� �� mark
		for(int finalIndex=0 ; finalIndex < lines*2-1 ; finalIndex++) {
			System.out.print(mark);
		}
	}

}
