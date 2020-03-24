package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class nO2816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] list = new String[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = br.readLine();
		}
		
		
		
		int idx1 = 0;
		int idx2 = 0;
		while(!list[idx1].equals("KBS1")) {
			idx1++;
		}
		while(!list[idx2].equals("KBS2")) {
			idx2++;
		}
		
		int firstKbs2 = 0;
		if(idx1 > idx2) {
			firstKbs2 = 1;
		}
		for(int i = 0 ; i < idx1; i++) {
			bw.write("1");
		}
		for(int i = 0 ; i < idx1; i++) {
			bw.write("4");
		}
		
		for(int i = 0 ; i < idx2+firstKbs2; i++) {
			bw.write("1"); // kbs1�� �� �ڿ� �ִٸ� kbs1�� 4�� �����ٺ��� kbs2�� ��ĭ �и���.
		}
		for(int i = 0 ; i < idx2+firstKbs2-1; i++) {
			bw.write("4"); //2��°�� �;��Ѵ�. idx2�� �Ѵٸ� 0�� �� -1�� �ȵǿ� 1��°�ΰ��� �ȴ�.
		}
		
		bw.flush();
	}
}
