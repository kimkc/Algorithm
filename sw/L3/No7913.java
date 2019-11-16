package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7913 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			String[] baseNnum = br.readLine().split(" ");
			int base = Integer.parseInt(baseNnum[0]);
			String Num = baseNnum[1];
			int sum = 0;
			int result = 0;
			
			for( int j = 0; j < Num.length(); j++) {
				sum += Num.charAt(j)-48;
			}
			
			result = sum % (base-1);
			
			
			System.out.println("#"+(i+1)+" "+result);
		}
	}
}

/*
10�ʶ� �ð� ������ �־����� ���������� ������ �ƴ� ���ϴ�.
9^2*2 9^1*3 9^0*4
162  27  	4			1

5^2*1 5^1*2 5^0*3
25		10	3			2

3^2*1 3^1*0 3^0*2
9		0	2 			1

-�� �ڸ� % (N-1)�� ���������� �� ���� �� % (n-1)�� �ϸ� ���� ���� ���� ��? ���� �������� �˱�
10^100000000*1�� �� �ִ�?
-���׽�Ʈ ���̽��� ���ԵǴ��� �𸣰����� �� �ڸ������� �׳� ���ؼ� %n-1�ϸ� ���̳���. 
�ڸ����� 10,000,000�̴ϱ� �� �ڸ��� �ִ� ���� 9 �ε� 9�� 10,000,000������ �־
 �� ���ص� 90,000,000�̾ȵ� int���� ��, �ٵ� 15/11���� ����, charAt -48����
*/