package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2293 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[] nNk = br.readLine().split(" ");
		int n = Integer.parseInt(nNk[0]);
		int k = Integer.parseInt(nNk[1]);
		int[] dp = new int[k+1];
		
		int[] coins = new int[n+1];
		dp[0] = 1;
		for(int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = coins[i]; j <= k; j++) {
				dp[j] += dp[j-coins[i]]; 
			}
		}
		
		System.out.println(dp[k]);
		
	}
}
