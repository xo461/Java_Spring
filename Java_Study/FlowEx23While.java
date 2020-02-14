package ch04condition;

public class FlowEx23While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//while과 for문 둘다 같은 값을 출력할 수 있지만
		//여기에서는 while이 더 간결하게 표현 가능.
		
		int i=1;
		while(i<=5) 
			System.out.println(i++);
		
		
		
		int m=1;
		for(;;) {
			if(!(m<=5)) 
				break;
			System.out.println(m);
		m++;}
		
		
		
	}

	}
