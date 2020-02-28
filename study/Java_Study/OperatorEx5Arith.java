package ch03operator;

public class OperatorEx5Arith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a = 10;
		int b = 4;
		int resi;
		double c = 6;

		//a+b 연산시 괄호를 쳐야 계산가능. 괄호없으면 문자로 취급해서 그냥 이어붙임

		System.out.println(a+" + "+b+" = "+a+b);
		System.out.println(a+" + "+b+" = "+(a+b));
	
		//easier
		System.out.printf("%d + %d = %d%n",a,b,a+b);
		
		//integer divided by integer = integer (자바: 소수점 버림) 
		System.out.println(a/b);
		
		//if one value is float/double, the result is also float/double
		System.out.println(a/c);

		//getting divided zero is unavailable
		//System.out.println(a/0);
		
		//remainder
		System.out.println(a%b);
		
		
		
		
		
		
		
	}

}
