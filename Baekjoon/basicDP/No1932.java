package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1932 {

	static int[][] triangle;
	static int[][] dp;
	
	static int dp(int n) {
		dp[0][0] = triangle[0][0];
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i+1; j++) {
				if( j == 0) {
					dp[i][j] = dp[i-1][j] + triangle[i][j];
				}else if(j == i) {
					dp[i][j] = dp[i-1][j-1] + triangle[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(dp[n-1][i] > max) {
				max = dp[n-1][i];
			}
		}
		return max;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		triangle = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dp(n));
	}
}
