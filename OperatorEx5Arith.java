package ch03operator;

public class OperatorEx5Arith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a = 10;
		int b = 4;
		int resi;
		double c = 6;

		//a+b ����� ��ȣ�� �ľ� ��갡��. ��ȣ������ ���ڷ� ����ؼ� �׳� �̾����

		System.out.println(a+" + "+b+" = "+a+b);
		System.out.println(a+" + "+b+" = "+(a+b));
	
		//easier
		System.out.printf("%d + %d = %d%n",a,b,a+b);
		
		//integer divided by integer = integer (�ڹ�: �Ҽ��� ����) 
		System.out.println(a/b);
		
		//if one value is float/double, the result is also float/double
		System.out.println(a/c);

		//getting divided zero is unavailable
		//System.out.println(a/0);
		
		//remainder
		System.out.println(a%b);
		
		
		
		
		
		
		
	}

}
