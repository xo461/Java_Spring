package javastudy.ch02var;

public class Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("변수 테스트");
		//변수선언: 예약어 안됨. 소문자 시작. 앞에 타입을 사용.
		int a = 10;
		a = 20;
		System.out.println(a);
		//기본형 변수 - 값으로 운영
		//참조형 변수 - 주소로 운영
		// (String은 다른 Object에 포함하지 않으면 기본형처럼 운영)
		// 
		String s = "string";  // new하지 않은건 ㄱ기본형변수처럼 운영
		String str = new String("string"); //new한건 참조형변수처럼 운영
		System.out.println("s="+s+", str"+str);
		VarObj vo = new VarObj(); 
		vo.str = str; //str이 다른 object에 넣어져잇음...
		System.out.printf("a = %d, s = %s, str = %s%n", a, s, vo.str);
	
		
		testType(a, s, vo);
		System.out.printf("a = %d, s = %s, str = %s%n", a, s, vo.str);
	}
	//typeTest를 위한 함수
	public static void testType(int a, String s, VarObj vo) {
		a = 100;
		s = "type change";
		vo.str = "type change - str";
		
	}
	
}
