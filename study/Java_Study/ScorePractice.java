/* Programming grades using Array * 
 * 
�л����� �Է¹޴´�.
�л��� ��ŭ ������ �Է� �޴´�. - �迭 ���
�հ�� ����� ���Ѵ�.
����� �л����� ������ ����Ѵ�.
�հ�� ����� ����Ѵ�. 
 */

package ch05array;

import java.util.Arrays;
import java.util.Scanner;

public class ScorePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ctrl enter �Է½� �ڵ����� import��
		Scanner scanner = new Scanner(System.in);
		
		int studentNumber=0;
		System.out.println("Enter the number of students :");
		studentNumber = scanner.nextInt();

		
		//**�л�����ŭ�� ������ �ִ� �迭 �غ�
		int [] studentScore = new int [studentNumber];
		
		for(int i=0; i<studentScore.length; i++) {
		System.out.println("Enter each student's scores _"+(i+1)+":");
		studentScore[i]=scanner.nextInt();
		System.out.println("Student's score is : ");
		System.out.println(Arrays.toString(studentScore));
		
		}
		
		int sum = 0;
		for(int score : studentScore) 
		sum += score;
		int avg = sum / studentScore.length;
		int avg1 = sum / studentNumber;
		
		System.out.printf("Total sum is : %d%n", sum);
		System.out.printf("Average is : %d%n", avg1);
		
			
	
		
	}

}
