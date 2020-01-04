package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BNo2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ropeNum = Integer.parseInt(br.readLine());
		int[] ropes = new int[ropeNum];
		for (int j = 0; j < ropeNum;  j++) {
			ropes[j] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes);
		
		int max=0;
		for(int i = 0; i < ropeNum; i++) {
			int weight = ropes[i]*(ropeNum-i);
			if(weight > max)
				max=weight;
		}
		
		bw.write(String.valueOf(max));
		bw.flush();

	}
}
