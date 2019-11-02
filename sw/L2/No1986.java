package L2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCaseNum; i++) {
			
			int testCase = Integer.parseInt(br.readLine());
			int sum = 0;
			System.out.print("#"+(i+1)+" ");
			
			for(int j = 1; j < testCase+1; j++) {
				if(j % 2 == 0) {
					sum-=j;
				}else {
					sum+=j;
				}
			}
			System.out.println(sum);
		}
	}
}
