package ch02variable;

//Scanner는 다른패키지(util)에 있으므로 import
//frequently used classes are automatically imported (such as java.lang)
import java.util.Scanner;

public class ScannerEx {

	//args자체가 주소임
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.in : System이라는 class , 그 안에 in이라는 ㅊ
		// 변수를 올릴 때 자동으로 static으로 메모리에 올리거나(프로그램이 짧거나 자주사용, 변수이름 못붙임. 자바가 직접 올리는거라.), 
		// new로 올림(필요할때 쓰고 필요 없을떄 내림, 그때그때 불러와서 쓰는 것. 그때마다 불러오는 주소가 바뀜..)
		// new: 새로 만든다. 메인메모리에 없던 것을 hdd에서 올림. 변수이름 지정한다. 
		//기본형데이터는(integer등)new로 안씀. 참조형데이터만 new로 씀
		//Scanner (type) scanner (변수이름. 참조형변수. 주소 저장.) = new Scanner
		Scanner scanner = new Scanner(System.in);
		System.out.print("두자리정수입력하세요:");
		
		//nextLine(): 엔터칠때까지 입력됨
		String input = scanner.nextLine();
		System.out.println(input);
		
		//input의 값은 문자열이고 10은 integer이기 때문에 출력시 그냥 연결시켜서출력
		System.out.println(input+10);
		
		//Integer.parseInt : 문자열을 integer로 바꿔줌
		//여기서 Integer는 wrapper class로서 기본형 데이터(여기선Int를 감싸는 클래스임)
		// ex. Integer.MAX_VALUE : the biggest integer...
		int num = Integer.parseInt(input);
		
		//num과 10 모두 integer가 되었으므로 더하기연산해서 출력
		System.out.print(num+10);
		
		//.close한 이후에 못씀...
		scanner.close();
		
	}

}
