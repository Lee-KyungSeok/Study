
/**
 * 
 * @author Kyung
 * Controlflow ���̵�3 ���� Ǯ��
 *
 */
public class Test03 {
	
	public void run(String mark, int lines) {
		
		// ���� �� ��ŭ �ݺ�
		for(int index=0 ; index<lines ; index=index+1) {
			
			// ���� ���
			for(int innerSpaceIndex=0 ; innerSpaceIndex < lines-index-1 ; innerSpaceIndex++) {
				
				System.out.print(" ");
			}
			
			// �� ���
			for(int innerMarkIndex=0 ; innerMarkIndex<index*2+1 ; innerMarkIndex++) {
				System.out.print(mark);
			}
			System.out.println("");
		}
	}
}
