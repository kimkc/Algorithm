package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2529gaza {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean[] checkN = new boolean[11];
	static boolean stopFor = false;
	static String[] inqualities;
	
	static void max(int[] result, int k, int n) throws IOException {
		if(k == n) {
			for(int i = 0; i < result.length; i++) {
				bw.write(String.valueOf(result[i]));
			}
			bw.write("\n");
			bw.flush();
			stopFor = true;
		}else if (inqualities[k].equals(">")) {
			for(int i = 0; i < checkN.length; i++) {
				checkN[i] = false;
			}
			for(int i = 0; i < result.length; i++) {
				checkN[result[i]] = true;
			}
			
			for(int i = 9; i > -1; i--) {
				if(stopFor == false && checkN[i] == false && result[k] > i ) {
					result[k+1] = i;
					max(result, k+1, n);
				}
			}
		}else if(inqualities[k].equals("<")) {
			for(int i = 0; i < checkN.length; i++) {
				checkN[i] = false;
			}
			for(int i = 0; i < result.length; i++) {
				checkN[result[i]] = true;
			}
			for(int i = 9; i > -1; i--) {
				if(stopFor == false &&  checkN[i] == false && result[k] < i ) {
					result[k+1] = i;
					max(result, k+1, n);
				}
			}
		}
	}
	
	static void min(int[] result, int k, int n) throws IOException {
		if(k == n) {
			for(int i = 0; i < result.length; i++) {
				bw.write(String.valueOf(result[i]));
				
			}
			bw.flush();
			stopFor = true;
		}else if (inqualities[k].equals(">")) {
			for(int i = 0; i < checkN.length; i++) {
				checkN[i] = false;
			}
			for(int i = 0; i < result.length; i++) {
				checkN[result[i]] = true;
			}
			for(int i = 0; i < 10; i++) {
				if(stopFor == false &&  checkN[i] == false && result[k] > i ) {
					result[k+1] = i;
					min(result, k+1, n);
				}
			}
		}else if(inqualities[k].equals("<")) {
			for(int i = 0; i < checkN.length; i++) {
				checkN[i] = false;
			}
			for(int i = 0; i < result.length; i++) {
				checkN[result[i]] = true;
			}
			for(int i = 0; i < 10; i++) {
				if(stopFor == false &&  checkN[i] == false && result[k] < i ) {
					result[k+1] = i;
					min(result, k+1, n);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int inqualityLen = Integer.parseInt(br.readLine());
		inqualities = br.readLine().split(" ");
		int[] result = new int[inqualityLen+1];
		
		for(int i = 0; i < result.length; i++) {
			result[i] = 10;
		}
		
		for(int i  = 9; i > -1; i--) {
			if(stopFor==false) {
				result[0] = i;
				max(result,0,inqualityLen);
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			result[i] = 10;
		}
		
		stopFor = false;
		
		for(int i  = 0; i < 10; i++) {
			if(stopFor==false) {
				result[0] = i;
				min(result,0,inqualityLen);
			}
		}
		
	}
}
