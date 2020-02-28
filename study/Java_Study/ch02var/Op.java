package javastudy.ch02var;

public class Op {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(10 % 3);
		// 배수 구하기 - 3의 배수 출력
		for(int i = 1; i <= 10; i++)
			if(i % 3 == 0) System.out.println(i);
		
		int a = 20;
		System.out.println(a++); // 출력 후 더하기
		System.out.println(++a); // 더하고 출력
		System.out.println(10 > 5); //true false
		System.out.println((10>5)?"크다":"크지않다."); // 삼항연산자 - 근데 10>5는 항상 true이므로 "크지않다"는 dead code라고 경고나옴.
	}
	

}
