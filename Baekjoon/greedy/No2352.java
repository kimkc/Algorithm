package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] weight = new int[40000];
		int[] check = new int[40000];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		check[0] = weight[0];
		int idx = 1;
		for(int i = 1; i < n; i++) {
			if(check[idx-1] < weight[i]) {
				check[idx] = weight[i];
				idx++;
				continue;
			}
			int iter = Arrays.binarySearch(check, 0, idx, weight[i]);
			iter = (iter < 0) ? -iter -1 : iter;
			check[iter] = weight[i];
			/*
			for(int x = 0; x < n; x++) {
				System.out.print(check[x]+" ");
			}
			System.out.println();
			*/
		}
		bw.write(String.valueOf(idx));
		bw.flush();
	}
}
