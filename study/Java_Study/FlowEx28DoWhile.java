//Number guessing game using Do & While loop

//컴퓨터로부터 1~100의 숫자를 입력받아서 사용자가 맞추는 게임
//do-while : 사용자 입력을 반복적으로 입력받을 때 유용함.


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
		//input이 answer이 같지 않다면 위의 loop를 반복하라.	
		
		System.out.println("You got the answer!!!");
		
	}
}