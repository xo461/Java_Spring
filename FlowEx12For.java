// printing 1~5 using for loop

package ch04condition;

public class FlowEx12For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//for loop:
		//for(�ʱⰪ ; �ݺ����� ; ������) {�ݺ�ó��}
				
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		//for������ ���� ������ for ���� ó���Ǹ� �����Ǳ� ������ 
		//for�� �ۿ��� ��� �Ұ�.
		//for�� �ۿ����� ���� ����ϰ��� �� ���: ������ �ۿ��� ����:
		
		int j=4;
		for (; j<=7; j++){
			System.out.println("This is J.");
		}

		int k=4;
		for (; k<=7; ){
			System.out.println("This is K.");
			k++;
		}	
		
		
		
		
		
		
		
		

	}

}
