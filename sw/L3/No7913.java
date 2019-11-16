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
10초란 시간 제한을 주었으니 빨리끝나는 공식이 아닐 듯하다.
9^2*2 9^1*3 9^0*4
162  27  	4			1

5^2*1 5^1*2 5^0*3
25		10	3			2

3^2*1 3^1*0 3^0*2
9		0	2 			1

-각 자리 % (N-1)한 나머지들을 다 더한 후 % (n-1)을 하면 같은 값이 나옴 왜? 인지 증명할줄 알기
10^100000000*1할 수 있니?
-위테스트 케이스만 포함되는지 모르겠지만 각 자리수들을 그냥 더해서 %n-1하면 값이나옴. 
자리수가 10,000,000이니까 한 자리수 최대 수가 9 인데 9가 10,000,000갯수로 있어도
 다 더해도 90,000,000이안됨 int범위 임, 근데 15/11개만 맞음, charAt -48안함
*/