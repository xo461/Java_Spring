package ch03operator;
import java.util.Scanner;

public class OperatorEx32Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Ű����� ���ڸ� �Է¹޾Ƽ� ���밪���� ����ϴ� ��ɹ�
		//���1 string���� �޾Ƽ� variable�� ����
		
		int x;
		String str;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ڸ� �Է��Ͻÿ�.");
		str=scanner.nextLine();
		x=Integer.parseInt(str);
		
		if (x<0) {
			x=-x;
		};		
		System.out.println(str);
		System.out.println(x);
		
		scanner.close();
		
		
		
		/*
		 * ���2 .nextInt�� �ƿ� Ű���� �Է¹��� �� ������ �ޱ�
		 * 	int x;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ڸ� �Է��Ͻÿ�.");
		
		x=scanner.nextInt();
		
		if (x<0) {
			x=-x;
		};
		System.out.print(x);
		
		scanner.close();
		 */
		
		
		
		/*
		 * ���ǹ� ���2
		 * ����? true�϶��ǰ� : false�϶��� ��
		 * x = (x<0)? -x:x;
		 * 
		 */
		
	}

}
