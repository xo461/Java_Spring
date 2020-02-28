//package: defining class's location
package ch02variable;

//public: enable to access to the class from other locations(other packages)
public class VariableClass{
	
	//static: �ּҰ� ����(�ڹٰ� ���������� �� �ڸ����� �޸𸮿� �ּҰ� �����Ǿ�����. ���ֻ���ϴ°ſ� ����.. ������ ������ ������� ����)
	//������������ ��쿡��  null �������. �ּҰ� ����ִ�. �׶� ����Ϸ����ϸ�  null point exception �߻�
	// 		 Use Classname.main  VariableClass.main()
	// void: doesn't exist
	/* ars : ����. parameter
	 * [] array
	 * main() : ()������ �ȿ� ����Ÿ�� ����...
	 * ó������ �޼ҵ� �ȿ�
	 */
	public static void main (String[] ars) {
		 byte b= 123; //1byte
		 short s = 123;//2byte
		 int i = 123;//4byte
		 long l = 123;//8byte
		 
		 System.out.println(b);
		 System.out.println(s);
		 System.out.println(i);
		 System.out.println(l);
		 
		 //ĳ����: ūŸ�Կ��� ����Ÿ�Կ� �����Ҷ�
		 //���������� Ÿ���� �����ִ°�
		 //������ ���� ���� ����
		 //���� ���ڳ��� , ���� ���ڳ��� �� ���� ���缺�վ�� ����
		 
//		 b=i; -> ūŸ�Կ��� ����Ÿ������ �ϸ� ������.
		 b=(byte)i; //casting. (changing type to byte) 
		 
		 //s = b+b; -> b+b int ���� ���� Ÿ�� ������ �ϸ�
		 // CPU�� ���µ� CPU�� �����ϴ� ��ġ�� int�� ������� int����
		 // s�� 2byte �̹Ƿ� short�� ĳ���� �ʿ�
		 s= (short)(b+b);
		 
		 //final - unchangable. constant ������ ����� �ۼ��Ҷ� ���
		 // (able to use in variables, methods, classes)
		 //final class - ������ ���� �Ұ�, final method - ��ȣ���� ó���� ���� �Ұ�, final ����  - �� ���� �Ұ�
		 final int FIT ;
		 FIT = 10; //need to assign first
		 System.out.println(FIT);
		 //���߸� ��� ã�ư��� �ذ�... ���ȵ� �� ������ ����Ʈ �� ���ְų� �ؼ� ����ؾߵ�...
//		 FIT = 20; // unable to assign more than once
		 
		 //char : 2 bytes
		 // assign one character only
		 // minus �� ���� 
		 char c = 'A';
		 System.out.println(c);
		 System.out.println((int)c);
		 System.out.println(c+1);
		 System.out.println((int)c+1);
		 System.out.println((char)(c+1));
		 
		 
		 //�����ּ�
		 /** Javadoc
		  * 
		  *  
		  *  */
		 /* �����ּ� */
		 
		 
	}
}