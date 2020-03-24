package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No14501 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+2];
		int max = 0;
		
		for(int i = 1 ; i <= n; i++) {
			String[] dayNvalue = br.readLine().split(" ");
			int day = Integer.parseInt(dayNvalue[0]);
			int value = Integer.parseInt(dayNvalue[1]);
			
			if(i+day < n+2) {
				int m = 0;
				for(int j = 1; j < i; j++) {
					if(m < dp[j])
						m = dp[j];
				}
				int price = 0;
				if(m < value) {
					price = value;
				}else {
					price = m;
				}
				if(dp[i+day] < price+dp[i]) {
					dp[i+day] = price+dp[i];
					
					if(max < dp[i+day]) {
						max = dp[i+day];
					}
				}
			}
		}
		
		
		for(int i = 1; i < n+2; i++) {
			System.out.println(i+" "+dp[i]);	
		}	
			
		System.out.println(max);	
		
	}
}
