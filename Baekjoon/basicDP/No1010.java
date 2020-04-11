package Baekjoon.DP;

import java.util.Scanner;

public class No1010 {
	
	static long makeDP(int n, int m, long[][] dp) {
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j <= m; j++) {
				if(dp[i][j] == 0) {
					int k = 1;
					while( i-1 <= j-k) {
						dp[i][j] += dp[i-1][j-k];
						k++;
					}
				}
			}
		}
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		 
		 Scanner sc = new Scanner(System.in);
	     
		 int testCase = sc.nextInt();
	     long[][] dp = new long[30][30];
		 
	     for(int i = 1; i < 30; i++) {
	    	 dp[1][i] = i;
	     }
	     
	     for(int q = 0; q < testCase; q++) {
	    	 int n = sc.nextInt();
	    	 int m = sc.nextInt();
	    	 
	    	 if(dp[n][m] == 0) {
	    		 System.out.println( makeDP(n, m, dp) );
	    	 }else{
	    		 System.out.println(dp[n][m]);
	    	 }
	     }
	        
	 }
}
