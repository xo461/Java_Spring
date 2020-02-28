// Ŭ������ ���� ��Ű��
package ch02variable;

// make a new class that has same name as its file name
public class PrintfEx1{
	//Ŭ���� ������
	public static void main(String[] args) {
	
	/* public: �ٸ� ��� ��ü���� ��� ����
	 * static: �ڹ� ������� ����
	 * void: main() ó���� ������ �����޴°� ����.
	 * return type: exist only in front of methods
	 * String: ������ ���� (ù�� �빮��)
	 * [] �迭. ������.
	 * args ���� �̸�. �������̹Ƿ� �ּҰ� ������
	 * 
	 * 
	 */
		int finger = 10;
		//���� ó���� ������ �ʱⰪ �����Ѱ�
		System.out.println(finger);
		System.out.println("finger="+finger);
		// ���ڿ��� �����ϸ� finger integer ���� string���� �ٲ����

		//println : ���� �״�� ���, �ٹٲ�����
		//printf : ���� �ٸ� �������� ��� ����, �ٹٲ޾���
		//%d 10������ ���
		//%n �ٹٲ�
		System.out.printf("finger=%d%n",finger);
		
		System.out.printf("finger=[%5d]%n",finger);

		// - �����������⺻������ �������ε�, -�ٿ��� ��������
		System.out.printf("finger=[%-5d]%n",finger);

		//���鹮�ڸ� 0���� ä��
		System.out.printf("finger=[%05d]%n",finger);

		// 16������ ��� %x
		System.out.printf("finger=[%x]%n",finger);

		//Integer.toBinaryString(finger)
		//basic class that changes integer to binary string (offered by Java)
		//inside the () method is finger
		System.out.printf("finger=[%s]%n",Integer.toBinaryString(finger));
		 
		
	
	
	}
	
}