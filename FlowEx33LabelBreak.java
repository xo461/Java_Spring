//Programming multiplication table using Break ������ ó����
// Break , Label, Continue ��

package ch05array;

public class FlowEx33LabelBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Loop1: //���� �ٿ��� �̵��� �� ����Ѵ�. -> switch{case ��: ~~}
		for(int i=2 ; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				
				//if(j == 5) break Loop1;				
				//break���������鼭 Loop1�� ��ġ�� �̵���

				//if(j == 5) continue Loop1;
				//j=5�϶� �ݺ����� ó������ �ٽ� �����ϱ� ������
				//j=5�϶��� ����� ���� ����.
				
				System.out.println(i + "*" + j + "=" + (i*j));
				
			}
			System.out.println();
		}
		System.out.println("������ ó�� ��~");
	}

}
