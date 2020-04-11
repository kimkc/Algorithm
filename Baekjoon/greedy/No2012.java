package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No2012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] grades = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			grades[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(grades);
		
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += Math.abs(grades[i]-i);
		}
		
		System.out.println(sum);
	}
}
