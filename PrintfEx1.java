// 클래스가 속한 패키지
package ch02variable;

// make a new class that has same name as its file name
public class PrintfEx1{
	//클래스 구성원
	public static void main(String[] args) {
	
	/* public: 다른 장소 객체에서 사용 가능
	 * static: 자바 종료까지 고정
	 * void: main() 처리가 끝나면 돌려받는게 없다.
	 * return type: exist only in front of methods
	 * String: 참조형 변수 (첫자 대문자)
	 * [] 배열. 여러개.
	 * args 변수 이름. 참조형이므로 주소가 들어가잇음
	 * 
	 * 
	 */
		int finger = 10;
		//값이 처음에 나오면 초기값 셋팅한것
		System.out.println(finger);
		System.out.println("finger="+finger);
		// 문자열과 연결하면 finger integer 값을 string으로 바꿔버림

		//println : 값을 그대로 출력, 줄바꿈해줌
		//printf : 값을 다른 형식으로 출력 가능, 줄바꿈안함
		//%d 10진수로 출력
		//%n 줄바꿈
		System.out.printf("finger=%d%n",finger);
		
		System.out.printf("finger=[%5d]%n",finger);

		// - 숫자정렬은기본적으로 오른쪽인데, -붙여서 왼쪽정렬
		System.out.printf("finger=[%-5d]%n",finger);

		//공백문자를 0으로 채움
		System.out.printf("finger=[%05d]%n",finger);

		// 16진수로 출력 %x
		System.out.printf("finger=[%x]%n",finger);

		//Integer.toBinaryString(finger)
		//basic class that changes integer to binary string (offered by Java)
		//inside the () method is finger
		System.out.printf("finger=[%s]%n",Integer.toBinaryString(finger));
		 
		
	
	
	}
	
}