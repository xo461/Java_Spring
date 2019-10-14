package ch03operator;
import java.util.Scanner;

public class OperatorEx32Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//키보드로 숫자를 입력받아서 절대값으로 출력하는 명령문
		//방법1 string으로 받아서 variable에 저장
		
		int x;
		String str;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하시오.");
		str=scanner.nextLine();
		x=Integer.parseInt(str);
		
		if (x<0) {
			x=-x;
		};		
		System.out.println(str);
		System.out.println(x);
		
		scanner.close();
		
		
		
		/*
		 * 방법2 .nextInt로 아예 키보드 입력받을 때 정수로 받기
		 * 	int x;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하시오.");
		
		x=scanner.nextInt();
		
		if (x<0) {
			x=-x;
		};
		System.out.print(x);
		
		scanner.close();
		 */
		
		
		
		/*
		 * 조건문 방법2
		 * 조건? true일때의값 : false일때의 값
		 * x = (x<0)? -x:x;
		 * 
		 */
		
	}

}
