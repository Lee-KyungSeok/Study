
/**
 * 
 * @author Kyung
 * Controlflow ���̵�1 ���� Ǯ��
 *
 */
public class Test01 {
	
	// ǥ���� ��, ǥ���� ���� �� �Է�
	public void run(String mark, int lines) {
		
		// ���θ�ŭ �ݺ�
		for(int index=0 ; index<lines ; index=index+1) {
			
			// �Էµ� �� ǥ��
			for(int innerIndex=0 ; innerIndex<index+1 ; innerIndex++) {
				System.out.print(mark);
			}
			System.out.println("");
		}
	}
}