package Baekjoon.DP;

import java.util.Scanner;

public class No9461 {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		long[] dp = new long[101];
		dp[1] = 1; dp[2] = 1; dp[3] =1;
		dp[4] = 2; dp[5] = 2;
		for(int i = 1; i <= testCase; i++) {
			int n = sc.nextInt();
			
			for(int j = 6; j <= n; j++) {
				if(dp[j] < 1) {
					dp[j] = dp[j-1]+dp[j-5];
				}
			}
			System.out.println(dp[n]);
		}
	}
}
