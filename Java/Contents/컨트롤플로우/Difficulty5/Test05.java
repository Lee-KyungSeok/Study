
/**
 * 
 * @author Kyung
 * Controlflow ���̵�5 ���� Ǯ��
 *
 */
public class Test05 {
	
	public void run(String mark, int lines) {
		
		for(int lineIndex =0 ; lineIndex<lines*2-1 ; lineIndex=lineIndex+1) {
			
			//���μ��� �Է°����� ���� ��� ����
			if(lineIndex<lines) {
				
				//ó�� ���� ���
				for(int outerSpaceIndex=0 ; outerSpaceIndex<lines-lineIndex-1 ; outerSpaceIndex=outerSpaceIndex+1) {
					System.out.print(" ");
				}
				
				// ó�� mark ���
				System.out.print(mark); 
				
				//��� ���� ����ϱ�
				for(int innerSpaceIndex=0 ; innerSpaceIndex<lineIndex*2-1 ; innerSpaceIndex=innerSpaceIndex+1) {
					System.out.print(" ");
				}
				
				//������ mark ���
				if(lineIndex==0) {
					System.out.println("");
				} else {
					System.out.println(mark); 					
				}
			}
			
			//���μ��� �Է°����� ũ�ų� ���� ��� ����
			else {
				
				//ó�� ���� ���
				for(int downOuterSpaceIndex=0 ; downOuterSpaceIndex<lineIndex-lines+1 ; downOuterSpaceIndex=downOuterSpaceIndex+1) {
					System.out.print(" ");
				}
				
				//ó�� mark ���
				System.out.print(mark);
				
				//��� ���� ���
				for(int downInnerSpaceIndex=0 ; downInnerSpaceIndex<4*lines-2*lineIndex-5 ; downInnerSpaceIndex=downInnerSpaceIndex+1) {
					System.out.print(" ");
				}
				
				//������ mark ���
				if(lineIndex!=lines*2-2) {
					System.out.println(mark);					
				} else {
					System.out.println("");
				}
				
			}
			
		}
		
	}

}
