package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7513 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			int testCase = Integer.parseInt(br.readLine());
			int count = 0;
			int rangeTestCase = (testCase/2)+2; //������ ���ݿ��� �ϳ� �̻� �������������� ���, �ð� ����, ���ӵ� ���� ���̱� ����
			
			for(int j = 0; j < rangeTestCase; j++) {
				int sum = 0;
				
				for(int k = j+1; k < rangeTestCase; k++) {
					sum +=k;
					if (sum == testCase) {
						count++;
					}
				}	
			}
			if(testCase == 1) {
				System.out.println("#"+(i+1)+" "+count);
			}else {
				System.out.println("#"+(i+1)+" "+(count+1)); //�ڱ��ڽ� �ϳ��� ��� �߰�
			}
		}
		
	}
}
