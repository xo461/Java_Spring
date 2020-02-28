package javastudy.ch02var;

public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 작 -> 큰: 크기(형태가 같다.)
		char c = 'A';
		short s = 0;
		int i = 0;
//		s = c; 큰 -> 작 : 오류발생
		s = (short) c;
		i = c; //자동캐스팅
		
		//Object의 캐스팅: 큰(부모)->작(자식): 강제캐스팅
		CastingSup sup = new CastingSup();
//		sup.
		CastingSub sub = new CastingSub();
//		sub. //안에 갖고있는 속성 확인 가능
		sub = (CastingSub) sup; //강제캐스팅
		sup = sub; //작->큰: 오토캐스팅
		

	}

}
