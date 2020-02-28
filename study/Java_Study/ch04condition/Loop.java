package javastudy.ch04condition;

public class Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1, j = 20; i<=10; i++, j++)
			System.out.println(i+"/"+j); //변수두개넣는방법도있다.
		
		
		//for loop -무한루프
		int i = 0;
		for(;;) { //초기값, 조건, 증감값 모두 생략 -> 조건을 본문에 적음 
			System.out.print(++i + " ");
			//10되기 전까지 계속
			if(i>=10) break;  
			if(i % 3 != 0) continue; //3으로 안나눠떨어지면 맨위로 돌아감.., 나눠떨어지면 밑에문장 실행
			System.out.println();
		}
		
		
//		while (True) {
//			System.exit(0); //프로그램빠져나가는조건
//		}

	
	
	
	
	}

}
