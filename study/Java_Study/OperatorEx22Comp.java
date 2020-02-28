package ch03operator;

public class OperatorEx22Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10;
		int b = 5;
		System.out.println(a>b);
		System.out.println(!(a>b));
	
		
		String str1 = "abcd";
		String str2 = "abcd";
		String str3 = new String("abcd");
		String str4 = new String("abcd");
		
		//string은 참조변수라 주소가 저장돼있음. 그래서 그 주소를 찾아가서 꺼내오는 것.str1~4 모두 참조형변수.
		//참조자료형은 == 를 이용해 비교하면 객체의 주소값을 비교함
				
		//str1~4의 주소를 아래와같이 찍어보면
		//str1,2의 주소는 같지만 나머진 다름..
		
		// string class의 hashcode 출력 (다같은결과)
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		//identity hash code 출력
		//(str1, 2는 같은 데이터이므로 같은 주소를 가르키도록 지정됨)
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
	
		//값은 abcd로 모두 같지만 str3,4는 new로 만들어줬기때문에 주소가 다르기때문에 String을 비교했을때 false값이 나오는 것.
		//new는 새로운 주소를 가리키고 그 주소는 동일한 abcd의 주소를 가리킴
		System.out.println(str1==str2);
		System.out.println(str1==str3);

		//값이 같은지만 비교할때는 아래와같이사용
		System.out.println(str1.equals(str3));

		
	
	
	}
	

}
