
/**
 * 
 * @author Kyung
 * Controlflow ���̵�2 ���� Ǯ��
 *
 */
public class Test02 {
	
	public void run(String mark, int lines) {
		
		// ���θ�ŭ �ݺ�
		for(int index=0 ; index<lines ; index=index+1) {
			
			// ó�� ���� �߰�
			for(int innerSpaceIndex=0 ; innerSpaceIndex < lines-index-1 ; innerSpaceIndex++) {
				
				System.out.print(" ");
			}
			
			// mark ǥ��
			for(int innerMarkIndex=0 ; innerMarkIndex<index+1 ; innerMarkIndex++) {
				System.out.print(mark);
			}
			
			System.out.println("");
		}
	}
}