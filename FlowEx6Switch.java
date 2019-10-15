//Programming seasons using Switch function
//계절 출력 프로그램
//연속된 데이터의 경우 if를 쓰고, equal형태인 경우 switch를 쓰는 것이 더 적절 (둘다 가능)

package ch04condition;

import java.util.Scanner;

public class FlowEx6Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the month in number.");
		System.out.println("Enter 0 to terminate the program");

		
//while문 사용시 : 반복 루프를 돌릴 중괄호 표시하고, 조건을 while문 안에 지정해야 하고, 루프를 빠져나갈 조건도 선언해야함.
		while (true) {

			int month = scanner.nextInt();
		
			switch (month) {
			case 1:
			case 2:
			case 3:
				System.out.println("It is spring.");
				break;

			case 4:
			case 5:
			case 6:
				System.out.println("It is summer.");
				break;

			case 7:
			case 8:
			case 9:
				System.out.println("It is fall.");
				break;

			case 10:
			case 11:
			case 12:
				System.out.println("It is winter.");
				break;

			case 0:
				System.out.println("The program has been terminated");
				System.exit(0);

			default:
				break;

			}
		}

	}

}
