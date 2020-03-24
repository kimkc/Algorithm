package Baekjoon.DP;

import java.util.Scanner;

public class No2193 {
	
	public static void main(String[] args){
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//int n = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n+1][2];
		dp[0][0] = 0; dp[0][1] = 0;
		dp[1][0] = 0; dp[1][1] = 1;
		dp[2][0] = 1; dp[2][1] = 0;
		for(int i =3; i <= n; i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		long d[][] = new long[n+1][2];
	    d[1][0] = 0;
	    d[1][1] = 1;

	    for(int i = 2; i <= n; i++){
	      d[i][0] = d[i-1][0] + d[i-1][1];
	      d[i][1] = d[i-1][0];
	    }
	    
	    for(int i = 0; i <= n; i++) {
	    	if(dp[i][0]+dp[i][1] != d[i][0]+d[i][1]) {
	    		System.out.println(i);
	    		break;
	    	}
	    	if(i == n) {
	    		System.out.println("¾ø´Ù");
	    	}
	    }
	}
	
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[] = new int[n+1];
		d[0] = 0; d[1] = 1; d[2] = 2;
		for(int i=3;i<=n;i++){
            d[i] = d[i-2] + d[i-1];
            d[i]%=15746;
        }
		System.out.println(d[n]);
		sc.close();
	}
	*/
}