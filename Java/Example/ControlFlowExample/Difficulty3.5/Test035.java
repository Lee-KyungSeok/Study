
/**
 * 
 * @author Kyung
 * Controlflow ���̵�3.5 ���� Ǯ��
 *
 */
public class Test035 {
	
	public void run(String mark, int lines) {
		
		//���μ���ŭ �ݺ�
		for(int index=0 ; index<lines ; index=index+1) {
			
			//������ �� ���� ǥ��
			for(int innerSpaceIndex=0 ; innerSpaceIndex < lines-index-1 ; innerSpaceIndex++) {				
				System.out.print(" ");
			}
			
			// ���� mark
			System.out.print(mark);
			
			//�� ���� ���� ǥ��
			for(int innerMarkIndex=0 ; innerMarkIndex<index*2-1 ; innerMarkIndex++) {
				System.out.print(" ");
			}
			
			//������ mark
			if(index==0) {
				System.out.println("");
			} else {
				System.out.println(mark);				
			}
		}
	}
}
