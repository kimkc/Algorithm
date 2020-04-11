package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class No1759 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		/*
		long sum = 0;
		for(int i = 0; i < n; i++) {
			int tip = Integer.parseInt(br.readLine());
			sum += tip;
		}
		long priority = (n-1)*n/2; //음수인 경우 0이 되어야하는데 이것이 포함되지 못했다.
		System.out.println(sum-priority);
		*/
		
		int[] tips = new int[n];
		long sum = 0;
		for(int i = 0; i < n; i++) {
			tips[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tips);
		int len = tips.length-1;
		
		for(int i = 0; i < n; i++) {
			int tip = tips[len-i]-i;
			if(tip > 0) {
				sum += tip;
			}
		}
		/*
		Arrays.sort(tips, Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			int tip = tips[i]-i;
			if(tip > 0) {
				sum += tip;
			}
		}
		*/
		System.out.println(sum);
	}
}
