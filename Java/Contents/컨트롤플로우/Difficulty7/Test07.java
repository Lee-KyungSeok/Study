
// 0+1+2+3+4+..., ..., 0+1+2, 0+1, 0 ���� �ʹ� ����
// ���μ� ��ŭ ���� ����
// 2*((���μ�-���ι�ȣ-1)), 2*((���μ�-���ι�ȣ-1)+(���μ�-���ι�ȣ-2)),... 

/**
 * 
 * Controlflow ���̵�7 ���� Ǯ��
 * mark���� ���� �Է°� lines �Է�
 * 
 * @author Kyung
 * 
 *
 */
public class Test07 {

	public void run(String mark, int lines) {
		
		for(int lineIndex=0; lineIndex<lines ; lineIndex=lineIndex+1) {
			
			//ó�� ���� ���
			for(int firstSpaceIndex=0 ; firstSpaceIndex<lines-lineIndex-1 ; firstSpaceIndex++) {
				
				for(int i=0 ; i<firstSpaceIndex+1 ; i++)
				{
					System.out.print(" ");
				}
			}
			
			//���� mark
			System.out.print(mark);
			
			//�� ���� ���� ǥ��
			//��� ���� ���
			for(int innerSpaceIndex=0 ; innerSpaceIndex<lines ; innerSpaceIndex=innerSpaceIndex+1) {
				System.out.print(" ");

			}
			//�߰� ���� ���
			for(int innerSpaceIndex2=0 ; innerSpaceIndex2<lineIndex ; innerSpaceIndex2++) {
				
				for(int i=0 ; i<2*(lines-innerSpaceIndex2)-2 ; i++)
				{
					System.out.print(" ");
				}	
			}
			
			//������ mark
				System.out.println(mark);
		}
	}

}