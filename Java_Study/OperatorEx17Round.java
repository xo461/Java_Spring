package ch03operator;

public class OperatorEx17Round {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	//syso ctrl space
	System.out.println("rounding-off");
	
	double pi = 3.141592;
	
	//4째자리에서 반올림하는법(자바에서는 이기능이따로 없어서 다소 번거롭게 진행됨..): 
	//3.141592*1000 = 3141.592 
	//3141.592 + 0.5 = 3142.092
	// integer로 변환 = 3142
	// 3142 / 1000 = 3.142
	
	double shortPi = (int)(pi*1000+0.5)/1000.0;
	System.out.println(shortPi);
	
	
	//Math : 수학연산모아놓은 클래스
	//Math.round() : rounding off
	
	double shorttPi = Math.round(pi*1000)/1000.0;
	System.out.println(shorttPi);
	
	//아래에 만든 round method 사용
	System.out.println(round(pi,4));
	
	}

	
	
	
	
	//creating a new method at the end of main method 
	//method를 직접 정의했기때문에 나중에 필요할때 가져다 쓸 수 있다.
	// rounding-off method declaration
	/**
	 * (round method를 나중에 가져다 쓸 때 마우스를 올려놓으면 아래와 같은 설명이 나옴
	 * @param d : 소수점있는 원본데이터 저장 변수
	 * @param p : 반올림위치
	 * @return : return the rounding-off result
	 */
	//자주쓰고 짧은거라 static 사용
	public static double round(double d, int p) {
		int mul = (int) Math.pow(10,p-1);
		System.out.println(mul);
		return Math.round(d*mul) / (double)mul;
	}
	
	
	
}
