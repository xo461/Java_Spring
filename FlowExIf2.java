//bus fare programming
//���� ��� ���α׷�

package ch04condition;

import java.util.Scanner;
public class FlowExIf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Enter your age : ");
		Scanner scanner = new Scanner(System.in);
		int age=scanner.nextInt();

		int fare=1250;
		
		if (age>=65)
			fare *=0.5;
			
		else if (20<=age)
			fare = 1250;
		
		else if (14<=age)
			fare *= 0.7;
			
		else if (7<=age)
			fare *= 0.5;
			
		else if (0<=age)
			fare = 0;
			
		else fare = -100;
		
		//10���� ���� ���:
		fare = fare /100 * 100 ;
	
		if(fare <0)
			System.out.println("Wrong Age");
		else 
			System.out.println("Your bus fare is " + fare + " won");
			
		scanner.close();
		
		
	}

}
