//Printing Grades
//학점 출력 프로그램

package ch04condition;
import java.util.Scanner;
public class FlowEx4Grade {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int scoree;

	Scanner scanner = new Scanner (System.in);
	
	System.out.println("Enter your score : ");
	
	scoree = scanner.nextInt();
	System.out.println("Your score : " +scoree);
	

	String grade = "";
	if (scoree > 100) grade="Error: score can't be over 100";
	else if (scoree >=90 && scoree <=100)
		grade="Your grade : A";
	else if (scoree >=80 && scoree <90)
		grade="Your grade : B";
	else if (scoree >=70 && scoree <80)
		grade="Your grade : C";
	else if (scoree >=60 && scoree <70)
		grade="Your grade : D";	
	else if (scoree >=0 && scoree <60)
		grade="Your grade : F";
	else if (scoree <0)
		grade="Error: score can't be lower than 0";
	
	System.out.println(grade);
	scanner.close();
	
	}
}
