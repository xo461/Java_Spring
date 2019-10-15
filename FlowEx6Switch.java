//Programming seasons using Switch function
//���� ��� ���α׷�
//���ӵ� �������� ��� if�� ����, equal������ ��� switch�� ���� ���� �� ���� (�Ѵ� ����)

package ch04condition;

import java.util.Scanner;

public class FlowEx6Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the month in number.");
		System.out.println("Enter 0 to terminate the program");

		
//while�� ���� : �ݺ� ������ ���� �߰�ȣ ǥ���ϰ�, ������ while�� �ȿ� �����ؾ� �ϰ�, ������ �������� ���ǵ� �����ؾ���.
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
