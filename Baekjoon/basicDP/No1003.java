package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1003 {
	static Fibo[] fiboes = new Fibo[41];
	
	public static Fibo count0N1(int n) {
		if(fiboes[n] != null) {
			return fiboes[n];
		}
		for(int i = 2; i <= n; i++) {
			if(fiboes[i] == null) {
				fiboes[i] = new Fibo(i,fiboes[i-1].zeroCount+fiboes[i-2].zeroCount, fiboes[i-1].oneCount+fiboes[i-2].oneCount);
			}
		}
		return fiboes[n];
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		fiboes[0] = new Fibo(0, 1, 0);
		fiboes[1] = new Fibo(1, 0, 1);
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			Fibo fibo = count0N1(n);
			bw.write(fibo.zeroCount+" "+fibo.oneCount+"\n");
		}
		bw.flush();
	}
}

class Fibo{
	int n;
	int zeroCount;
	int oneCount;
	
	Fibo(int n, int zero, int one){
		this.n = n;
		this.zeroCount = zero;
		this.oneCount = one;
	}
}
