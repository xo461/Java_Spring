//Number guessing game using Do & While loop

//��ǻ�ͷκ��� 1~100�� ���ڸ� �Է¹޾Ƽ� ����ڰ� ���ߴ� ����
//do-while : ����� �Է��� �ݺ������� �Է¹��� �� ������.


package ch05array;

import java.util.Scanner;

public class FlowEx28DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int input=0, answer=0;
		answer = (int)(Math.random()*100);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Let's play a number guessing game!");
		
		System.out.println("Enter a number between 1~100.");
		do {
			input = scanner.nextInt();
			
			if(input > answer)
				System.out.println("Enter a smaller number.");
			
			else if(input < answer)
				System.out.println("Enter a bigger number.");
			
		} 
		while (input != answer);
		//input�� answer�� ���� �ʴٸ� ���� loop�� �ݺ��϶�.	
		
		System.out.println("You got the answer!!!");
		
	}
}