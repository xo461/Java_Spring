package javastudy.ch04condition;

public class If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {-50, 0, 59, 69, 79, 89};
		
		for(int s: scores) //함수에 넣을 변수 for문 
			grade(s); //함수호출
	}	
	public static void grade(int score) {
		System.out.print("score:"+score);
			if (score >= 80) System.out.println("good job");
		else System.out.println("study harder");
	
	}
}
