package ch03operator;

public class OperatorEx17Round {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	//syso ctrl space
	System.out.println("rounding-off");
	
	double pi = 3.141592;
	
	//4°�ڸ����� �ݿø��ϴ¹�(�ڹٿ����� �̱���̵��� ��� �ټ� ���ŷӰ� �����..): 
	//3.141592*1000 = 3141.592 
	//3141.592 + 0.5 = 3142.092
	// integer�� ��ȯ = 3142
	// 3142 / 1000 = 3.142
	
	double shortPi = (int)(pi*1000+0.5)/1000.0;
	System.out.println(shortPi);
	
	
	//Math : ���п����Ƴ��� Ŭ����
	//Math.round() : rounding off
	
	double shorttPi = Math.round(pi*1000)/1000.0;
	System.out.println(shorttPi);
	
	//�Ʒ��� ���� round method ���
	System.out.println(round(pi,4));
	
	}

	
	
	
	
	//creating a new method at the end of main method 
	//method�� ���� �����߱⶧���� ���߿� �ʿ��Ҷ� ������ �� �� �ִ�.
	// rounding-off method declaration
	/**
	 * (round method�� ���߿� ������ �� �� ���콺�� �÷������� �Ʒ��� ���� ������ ����
	 * @param d : �Ҽ����ִ� ���������� ���� ����
	 * @param p : �ݿø���ġ
	 * @return : return the rounding-off result
	 */
	//���־��� ª���Ŷ� static ���
	public static double round(double d, int p) {
		int mul = (int) Math.pow(10,p-1);
		System.out.println(mul);
		return Math.round(d*mul) / (double)mul;
	}
	
	
	
}
