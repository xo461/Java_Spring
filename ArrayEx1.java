//programming scores using Array 

package ch05array;

import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//배열: 같은 타입의 '참조형 또는 기본형' 데이터를 저장하는 저장소로서
		//생성될 때 그 크기가 고정되는 "객체"
		//배열 선언 = 5개의 int값을 저장할수 있는 배열을 생성한다.
		//참조형은 메모리에 올려야(배열생성) 가져다 사용이 가능하기 때문에 new(생성)를 써준다.
		int[] score = new int[]{50,60,70,80,90};
		
		//new를 생략 가능하지만, 매개변수를 받을 경우 new생략 불가
		//int[] score = {50,60,70,80,90};

		
		int sum =0;
		
		for(int i=0; i<=4; i++) {
			System.out.println(score[i]);
			sum += score[i];
			
		}
		
			
		System.out.println("Total sum of your scores is " + sum + ".");
		
		//Array는 객체. 출력시 데이터타입과 주소값이 나옴
		System.out.println(score);
		
		
		
		
		//foreach loop (향상된 for문. p.166)
		//:배열또는 컬렉션에 저장된 값이 반복마다 하나씩 꺼내져와 처리후 변수로 저장됨
		//for(타입 변수명 : 배열 또는 컬렉션) {반복할문장}
		sum=0;
		for(int s:score) {
			System.out.println(s);
			sum+=s;
		}
		System.out.println("Sum is "+sum+".");
		
		
		
		
		//인덱스를 사용할 때 모든 배열의 갯수만큼 처리(배열의 갯수가 변경되어도 가능)
		for (int i = 0; i < score.length ; i++)
			System.out.println(score[i]);

		
		//배열을 출력형식의 문자열로 만들어주는 method : Arrays
		//toString을 써서 static으로 만들어줌
		System.out.println(Arrays.toString(score));
		
		
	}

}
