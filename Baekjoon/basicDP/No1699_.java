package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1699_ {
	public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 32;//Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i =2; i <= n; i++){
        	int min = 10000000;
        	int temp = 0;
        	int sqrt = (int)Math.sqrt(i);
        	for(int j = 1; j <= sqrt; j++) {
        		temp = 1 + dp[i-(int)Math.pow(j,2)];
        		if(temp < min)
        			min = temp;
        	}
        	dp[i] = min;
        }
        System.out.println(dp[n]);
	}
	/*
	private static int[] minArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		minArr = new int[n + 1];
		System.out.println(findMin(n));
	}
	
	private static int findMin(int n) {
		
		if(minArr[n] != 0) {
			return minArr[n];
		}
		
		int min = n;
		int i = (int) Math.sqrt(n);
		
		while(i > 1) {
			int q = n / (i * i);
			int m = n % (i * i);
			int tmp = q + findMin(m);
			if(min > tmp) {
				min = tmp;
			}
			
			i--;
		}
		
		minArr[n] = min;
		return min;
	}
	*/
}
