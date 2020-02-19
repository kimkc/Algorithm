package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		int[] oneZero = new int[2];
		int len = s.length();
		
		for(int i = 0; i < len-1; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				oneZero[s.charAt(i)-'0']++;
				if( i == len-2) {
					oneZero[s.charAt(i+1)-'0']++;
				}
			}
			if(i == len-2 && s.charAt(i) == s.charAt(i+1)){
				oneZero[s.charAt(i)-'0']++;
			}
		}
		
		int min = 500000;
		for(int i = 0; i < 2; i++) {
			if(oneZero[i] < min) {
				min = oneZero[i];
			}
		}
		System.out.println(min);
	}
}
