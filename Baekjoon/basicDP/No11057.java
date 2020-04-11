package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11057 {
	
	public static int suc(int n) {
		int[][] dp = new int[n+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][k] += dp[i-1][j];
					dp[i][k] %= 10007;
				}
				if(i==8) {
					System.out.println(" "+i+""+j+" "+dp[i][j]);
				}
			}
		}
		System.out.println("            ");
		int sum = 0;
		for(int k = 0; k < 10; k++) {
			sum += dp[n][k];
		}
		return sum%10007;
	}
	
	public static int me(int n) {
		int[][] dp = new int[n+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		/* �� ���� �´� �˰��� 
		for(int i = 2; i <= n; i++) {
			for(int  j = 0;  j < 10; j++) {
				for(int k =j; k < 10; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
			*/
		//���� �˰����� ������ ���궧���� 8���� -����鿡 ���� -������ ������ �����Ѵ�.
		for(int i = 2; i <= n; i++) {			
			int sum = 0;
			for(int k = 0; k < 10; k++) {
				sum += dp[i-1][k];
			}
			dp[i][0] = sum%10007;//
			for(int j = 1; j < 10; j++) {
				dp[i][j] = dp[i][j-1] - dp[i-1][j-1];//�������������� ũ�Ⱑ �۾����ٴ� ������ ����
				if(i==8) {
					System.out.println(" "+j+" "+dp[i][j]);
				}
			}
		}
		
		int sum = 0;
		for(int k = 0; k < 10; k++) {
			sum += dp[n][k];
		}
		return sum%10007;//
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nLen = Integer.parseInt(br.readLine());
		for(int i = 1; i < 1001; i++) {
			if(suc(i) != me(i)) {
				System.out.println(i);
				break;
			}
		}
		System.out.println("end");
	}
		/*
		int[][] dp = new int[nLen+1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= nLen; i++) {
			int sum = 0;
			for(int k = 0; k < 10; k++) {
				sum += dp[i-1][k];
			}
			dp[i][0] = sum%10007;
			for(int j = 1; j < 10; j++) {
				dp[i][j] = dp[i][j-1] - dp[i-1][j-1]%10007;
			}
		}
		
		int sum = 0;
		for(int k = 0; k < 10; k++) {
			sum += dp[nLen][k]%10007;
		}
		System.out.println(sum);
	}
	*/
}
