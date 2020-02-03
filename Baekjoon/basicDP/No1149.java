package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No1149 {
	static int[][] dp;
	static int[][] rgbPrices;
	
	public static void makeMinPrices(int y) {
		dp[y][0] = Math.min(dp[y-1][1], dp[y-1][2])+rgbPrices[y][0];
		dp[y][1] = Math.min(dp[y-1][0], dp[y-1][2])+rgbPrices[y][1];
		dp[y][2] = Math.min(dp[y-1][1], dp[y-1][0])+rgbPrices[y][2];
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int houseNum = Integer.parseInt(br.readLine());
		rgbPrices = new int[houseNum][3];
		dp = new int[houseNum][3];
		for(int i = 0; i < houseNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				rgbPrices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = rgbPrices[0][0]; dp[0][1] = rgbPrices[0][1]; dp[0][2] = rgbPrices[0][2];
		
		
		for(int i = 1; i < houseNum; i++) {
			makeMinPrices(i);
		}
		
		int min = 10000000;
		for(int i = 0; i < 3; i++) {
			if(dp[houseNum-1][i] < min) {
				min = dp[houseNum-1][i];
			}
		}
		System.out.println(min);
		
	}
	/*
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int houseNum = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] rgbPrice = new int[3];
		
		int min;
		int beforeColor = -1; // 전 인덱스의 색깔
		int tempBefore = -1;
		
		for(int i = 0; i < houseNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			min = 1000;
			
			for(int j = 0; j < 3; j++) {
				rgbPrice[j] = Integer.parseInt(st.nextToken());
				if(beforeColor != j && min > rgbPrice[j]) {
					min = rgbPrice[j];
					tempBefore = j; //beforeColor에 바로 대입하면 전 인덱스의 색깔이 유지 되지 않아 if문이 제대로 적용되지 못함
				}
			}
			beforeColor = tempBefore;
			sum += min;
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}
	*/
}

