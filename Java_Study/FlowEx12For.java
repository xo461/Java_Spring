// printing 1~5 using for loop

package ch04condition;

public class FlowEx12For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//for loop:
		//for(초기값 ; 반복조건 ; 증감값) {반복처리}
				
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		//for문에서 만든 변수는 for 문이 처리되면 삭제되기 때문에 
		//for문 밖에서 사용 불가.
		//for문 밖에서도 변수 사용하고자 할 경우: 변수를 밖에서 선언:
		
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
