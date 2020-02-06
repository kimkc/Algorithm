package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2156 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] grapeGlasses = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			grapeGlasses[i] = Integer.parseInt(br.readLine());
		}
		if(n>=1)//
		    dp[0] = grapeGlasses[0];
		if(n>=2)//
            dp[1] = grapeGlasses[0]+grapeGlasses[1];
        if(n>=3)//
		    dp[2] =  Math.max(dp[1], Math.max(dp[0] + grapeGlasses[2], grapeGlasses[1] + grapeGlasses[2]));
        //dp[2] = Math.max(dp[0], grapeGlasses[1])+grapeGlasses[2];
		for(int i = 3; i < n; i++) {
			//dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+grapeGlasses[i]+grapeGlasses[i-1], dp[i-2]+grapeGlasses[i]));
            dp[i] = Math.max(dp[i-2], dp[i-3]+grapeGlasses[i-1])+grapeGlasses[i];
			dp[i] = Math.max(dp[i-1], dp[i]); 
		}
		System.out.println(dp[n-1]);
	}
	}
}
 