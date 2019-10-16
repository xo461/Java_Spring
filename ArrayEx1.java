//programming scores using Array 

package ch05array;

import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//�迭: ���� Ÿ���� '������ �Ǵ� �⺻��' �����͸� �����ϴ� ����ҷμ�
		//������ �� �� ũ�Ⱑ �����Ǵ� "��ü"
		//�迭 ���� = 5���� int���� �����Ҽ� �ִ� �迭�� �����Ѵ�.
		//�������� �޸𸮿� �÷���(�迭����) ������ ����� �����ϱ� ������ new(����)�� ���ش�.
		int[] score = new int[]{50,60,70,80,90};
		
		//new�� ���� ����������, �Ű������� ���� ��� new���� �Ұ�
		//int[] score = {50,60,70,80,90};

		
		int sum =0;
		
		for(int i=0; i<=4; i++) {
			System.out.println(score[i]);
			sum += score[i];
			
		}
		
			
		System.out.println("Total sum of your scores is " + sum + ".");
		
		//Array�� ��ü. ��½� ������Ÿ�԰� �ּҰ��� ����
		System.out.println(score);
		
		
		
		
		//foreach loop (���� for��. p.166)
		//:�迭�Ǵ� �÷��ǿ� ����� ���� �ݺ����� �ϳ��� �������� ó���� ������ �����
		//for(Ÿ�� ������ : �迭 �Ǵ� �÷���) {�ݺ��ҹ���}
		sum=0;
		for(int s:score) {
			System.out.println(s);
			sum+=s;
		}
		System.out.println("Sum is "+sum+".");
		
		
		
		
		//�ε����� ����� �� ��� �迭�� ������ŭ ó��(�迭�� ������ ����Ǿ ����)
		for (int i = 0; i < score.length ; i++)
			System.out.println(score[i]);

		
		//�迭�� ��������� ���ڿ��� ������ִ� method : Arrays
		//toString�� �Ἥ static���� �������
		System.out.println(Arrays.toString(score));
		
		
	}

}
