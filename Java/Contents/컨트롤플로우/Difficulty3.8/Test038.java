
/**
 * 
 * @author Kyung
 * Controlflow ���̵�3.8 ���� Ǯ��
 *
 */
public class Test038 {
	
	public void run(String mark, int lines) {
		
		//���μ� ��ŭ �ݺ�
		for(int index=0 ; index<lines*2-1 ; index=index+1) {
			
			//���μ��� �Է°����� ������� ����
			if(index<lines){
				
				// ������ �� ���鰪
				for(int innerSpaceIndex=0 ; innerSpaceIndex < lines-index-1 ; innerSpaceIndex++) {
					System.out.print(" ");
				}
				
				// mark ǥ��
				for(int innerMarkIndex=0 ; innerMarkIndex<2*index+1 ; innerMarkIndex++) {
					System.out.print(mark);
				}
				System.out.println("");
			}
			// ���μ��� �Է°����� ũ�ų� ���� ��� ����
			else {
				
				//������ �� ���鰪
				for(int downSpaceIndex=0 ; downSpaceIndex < index-lines+1 ; downSpaceIndex++) {					
					System.out.print(" ");
				}
				
				//�� ǥ��
				for(int downMarkIndex=0 ; downMarkIndex<4*lines-2*index-3 ; downMarkIndex++) {
					System.out.print(mark);
				}
				System.out.println("");
			}
		}
	}

}
