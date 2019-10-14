package ch02variable;

//Scanner�� �ٸ���Ű��(util)�� �����Ƿ� import
//frequently used classes are automatically imported (such as java.lang)
import java.util.Scanner;

public class ScannerEx {

	//args��ü�� �ּ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.in : System�̶�� class , �� �ȿ� in�̶�� ��
		// ������ �ø� �� �ڵ����� static���� �޸𸮿� �ø��ų�(���α׷��� ª�ų� ���ֻ��, �����̸� ������. �ڹٰ� ���� �ø��°Ŷ�.), 
		// new�� �ø�(�ʿ��Ҷ� ���� �ʿ� ������ ����, �׶��׶� �ҷ��ͼ� ���� ��. �׶����� �ҷ����� �ּҰ� �ٲ�..)
		// new: ���� �����. ���θ޸𸮿� ���� ���� hdd���� �ø�. �����̸� �����Ѵ�. 
		//�⺻�������ʹ�(integer��)new�� �Ⱦ�. �����������͸� new�� ��
		//Scanner (type) scanner (�����̸�. ����������. �ּ� ����.) = new Scanner
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڸ������Է��ϼ���:");
		
		//nextLine(): ����ĥ������ �Էµ�
		String input = scanner.nextLine();
		System.out.println(input);
		
		//input�� ���� ���ڿ��̰� 10�� integer�̱� ������ ��½� �׳� ������Ѽ����
		System.out.println(input+10);
		
		//Integer.parseInt : ���ڿ��� integer�� �ٲ���
		//���⼭ Integer�� wrapper class�μ� �⺻�� ������(���⼱Int�� ���δ� Ŭ������)
		// ex. Integer.MAX_VALUE : the biggest integer...
		int num = Integer.parseInt(input);
		
		//num�� 10 ��� integer�� �Ǿ����Ƿ� ���ϱ⿬���ؼ� ���
		System.out.print(num+10);
		
		//.close�� ���Ŀ� ����...
		scanner.close();
		
	}

}
