//package: defining class's location
package ch02variable;

//public: enable to access to the class from other locations(other packages)
public class VariableClass{
	
	//static: 주소가 고정(자바가 끝날때까지 그 자리에서 메모리에 주소가 고정되어있음. 자주사용하는거에 적합.. 참조형 변수로 사용하지 않음)
	//참조형변수인 경우에만  null 집어넣음. 주소가 비어있다. 그때 사용하려고하면  null point exception 발생
	// 		 Use Classname.main  VariableClass.main()
	// void: doesn't exist
	/* ars : 변수. parameter
	 * [] array
	 * main() : ()있으면 안에 리턴타입 놓음...
	 * 처리문은 메소드 안에
	 */
	public static void main (String[] ars) {
		 byte b= 123; //1byte
		 short s = 123;//2byte
		 int i = 123;//4byte
		 long l = 123;//8byte
		 
		 System.out.println(b);
		 System.out.println(s);
		 System.out.println(i);
		 System.out.println(l);
		 
		 //캐스팅: 큰타입에서 작은타입에 대입할때
		 //강제적으로 타입을 맞춰주는것
		 //데이터 유실 위험 감수
		 //숫자 숫자끼리 , 문자 문자끼리 등 서로 유사성잇어야 가능
		 
//		 b=i; -> 큰타입에서 작은타입으로 하면 에러남.
		 b=(byte)i; //casting. (changing type to byte) 
		 
		 //s = b+b; -> b+b int 보다 작은 타입 연산을 하면
		 // CPU에 들어가는데 CPU에 저장하는 장치가 int라 결과값이 int나옴
		 // s는 2byte 이므로 short로 캐스팅 필요
		 s= (short)(b+b);
		 
		 //final - unchangable. constant 변수를 상수로 작성할때 사용
		 // (able to use in variables, methods, classes)
		 //final class - 구성원 변경 불가, final method - 괄호안의 처리문 변경 불가, final 변수  - 값 변경 불가
		 final int FIT ;
		 FIT = 10; //need to assign first
		 System.out.println(FIT);
		 //경고뜨면 경고 찾아가서 해결... 사용안된 것 있으면 프린트 함 해주거나 해서 사용해야됨...
//		 FIT = 20; // unable to assign more than once
		 
		 //char : 2 bytes
		 // assign one character only
		 // minus 값 없음 
		 char c = 'A';
		 System.out.println(c);
		 System.out.println((int)c);
		 System.out.println(c+1);
		 System.out.println((int)c+1);
		 System.out.println((char)(c+1));
		 
		 
		 //한줄주석
		 /** Javadoc
		  * 
		  *  
		  *  */
		 /* 범위주석 */
		 
		 
	}
}