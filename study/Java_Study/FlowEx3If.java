/*������ �Է¹޾Ƽ� �հݿ��θ� ����ϴ� ���α׷�
60�� �̻��̸� �հ�, �׷��� ������ ���հ�

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