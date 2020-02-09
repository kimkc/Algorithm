package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No3750 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1; i <= testCase; i++) {	
			String num = br.readLine();
			int sum = 0;
			for(int j = 0; j < num.length(); j++) {
				sum += num.charAt(j)-'0';
			}
			while(sum/10 != 0) {
				num = String.valueOf(sum);
				sum = 0;
				for(int j = 0; j < num.length(); j++) {
					sum += num.charAt(j)-'0';
				}
			}
			System.out.println("#"+i+" "+sum);
		}
	}
}
