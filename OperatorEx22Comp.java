package ch03operator;

public class OperatorEx22Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10;
		int b = 5;
		System.out.println(a>b);
		System.out.println(!(a>b));
	
		
		String str1 = "abcd";
		String str2 = "abcd";
		String str3 = new String("abcd");
		String str4 = new String("abcd");
		
		//string�� ���������� �ּҰ� ���������. �׷��� �� �ּҸ� ã�ư��� �������� ��.str1~4 ��� ����������.
		//�����ڷ����� == �� �̿��� ���ϸ� ��ü�� �ּҰ��� ����
				
		//str1~4�� �ּҸ� �Ʒ��Ͱ��� ����
		//str1,2�� �ּҴ� ������ ������ �ٸ�..
		
		// string class�� hashcode ��� (�ٰ������)
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		//identity hash code ���
		//(str1, 2�� ���� �������̹Ƿ� ���� �ּҸ� ����Ű���� ������)
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
	
		//���� abcd�� ��� ������ str3,4�� new�� �������⶧���� �ּҰ� �ٸ��⶧���� String�� �������� false���� ������ ��.
		//new�� ���ο� �ּҸ� ����Ű�� �� �ּҴ� ������ abcd�� �ּҸ� ����Ŵ
		System.out.println(str1==str2);
		System.out.println(str1==str3);

		//���� �������� ���Ҷ��� �Ʒ��Ͱ��̻��
		System.out.println(str1.equals(str3));

		
	
	
	}
	

}
