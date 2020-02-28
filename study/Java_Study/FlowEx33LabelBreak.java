//Programming multiplication table using Break 구구단 처리문
// Break , Label, Continue 문

package ch05array;

public class FlowEx33LabelBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Loop1: //라벨을 붙여서 이동할 때 사용한다. -> switch{case 값: ~~}
		for(int i=2 ; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				
				//if(j == 5) break Loop1;				
				//break빠져나오면서 Loop1의 위치로 이동함

				//if(j == 5) continue Loop1;
				//j=5일때 반복문을 처음부터 다시 시작하기 때문에
				//j=5일때는 출력을 하지 않음.
				
				System.out.println(i + "*" + j + "=" + (i*j));
				
			}
			System.out.println();
		}
		System.out.println("구구단 처리 끝~");
	}

}
