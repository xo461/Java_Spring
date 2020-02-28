package ch03operator;

public class OperatorEx1SingleOp{
	
	public static void main(String[] args) {
		
		//단항연산자 (항이 1개..i...)
		//i value  defining
		int i = 5;
		System.out.println("i="+i);
		i=i+1;
		System.out.println("i="+i);
		i += 1;
		System.out.println("i="+i);
		
		//후증가, 선증가 (단독으로 처리할떄는 결과 동일)
		i++;
		System.out.println("i="+i);
		++i;
		System.out.println("i="+i);
		
		
		
	}
	
}
	
