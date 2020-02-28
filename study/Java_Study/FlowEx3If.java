/*점수를 입력받아서 합격여부를 출력하는 프로그램
60점 이상이면 합격, 그렇지 않으면 불합격

*/
package ch04condition;
import java.util.Scanner;

public class FlowEx3If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner scanner = new Scanner (System.in);
	System.out.println("Enter your score:");	
	
	int score=scanner.nextInt();
	System.out.println("score: " + score);
	
	if (score >100) 
		System.out.println("Error : score is over 100");
		else if(score>=60)
			System.out.println("pass");
		else if (0<= score && score < 60)
			System.out.println("fail");
		else 
			System.out.println("Error : score is below 0");	
		;
		
		scanner.close();

	}
	}