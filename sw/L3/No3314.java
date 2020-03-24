package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3314 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1; i <= testCase; i ++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				int score = Integer.parseInt(st.nextToken());
				if(score < 40) {
					sum += 40;
				}else {
					sum += score;
				}
			}
			
			System.out.println("#"+i+" "+(sum/5));
		}
		
		
	}
}
