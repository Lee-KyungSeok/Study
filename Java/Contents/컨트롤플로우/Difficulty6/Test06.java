
//���� �Է°���ŭ
//ó�� ������ 0, 6, 6+5, 6+5+4...

/**
 * 
 * Controlflow ���̵�6 ���� Ǯ��
 * mark���� ���� �Է°� lines �Է�
 * 
 * @author Kyung
 * 
 *
 */
public class Test06 {
	
	public void run(String mark, int lines) {
		
		// ���μ���ŭ �ݺ�
		for(int lineIndex=0; lineIndex<lines ; lineIndex=lineIndex+1) {
			
			//ó�� ���� ���
			for(int firstSpaceIndex=0 ; firstSpaceIndex<lineIndex ; firstSpaceIndex++) {
				
				for(int i=0 ; i<lines-firstSpaceIndex-1 ; i++)
				{
					System.out.print(" ");
				}
			}
			
			//(mark+����)�� �Ѽ�Ʈ�� ���
			for(int setIndex=0;setIndex<lines-lineIndex; setIndex=setIndex+1) {
				
				//mark�ϰ�
				System.out.print(mark);
				
				//��� ���� ���
				for(int middleSpaceIndex=0; middleSpaceIndex<lines-lineIndex-1 ; middleSpaceIndex=middleSpaceIndex+1) {
					System.out.print(" ");
				}
				
			}
				System.out.println("");

		}
	}

}
