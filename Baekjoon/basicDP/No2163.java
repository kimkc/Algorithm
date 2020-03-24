package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2163 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[] nNm = br.readLine().split(" ");
		System.out.println((Integer.parseInt(nNm[1])-1)*Integer.parseInt(nNm[0])+Integer.parseInt(nNm[0])-1);
		
	}
}
