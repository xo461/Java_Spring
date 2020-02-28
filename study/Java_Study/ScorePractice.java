/* Programming grades using Array * 
 * 
학생수를 입력받는다.
학생수 만큼 점수를 입력 받는다. - 배열 사용
합계와 평균을 구한다.
출력은 학생들의 점수를 출력한다.
합계와 평균을 출력한다. 
 */

package ch05array;

import java.util.Arrays;
import java.util.Scanner;

public class ScorePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ctrl enter 입력시 자동으로 import됨
		Scanner scanner = new Scanner(System.in);
		
		int studentNumber=0;
		System.out.println("Enter the number of students :");
		studentNumber = scanner.nextInt();

		
		//**학생수만큼의 개수가 있는 배열 준비
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
