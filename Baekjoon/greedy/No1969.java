package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No1969 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] nucles = {'A','C','G','T'};
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int n = Integer.parseInt(st.nextToken());
		int strLen = Integer.parseInt(st.nextToken());
		
		char[][] dnas = new char[n][strLen];
		for(int i = 0; i < n; i++) {
			String dna = br.readLine();
			for(int j = 0; j < strLen; j++) {
				dnas[i][j] = dna.charAt(j);
			}
		}
		
		int hammingDistance = 0;
		for(int i = 0; i < strLen; i++) {
			int[] count = new int[4];
			for(int j = 0; j < n; j++) {
				if(dnas[j][i] == 'A') {
					count[0]++;
				}else if(dnas[j][i] == 'C') {
					count[1]++;
				}else if(dnas[j][i] == 'G') {
					count[2]++;
				}else {
					count[3]++;
				}
			}
			//최대값과 인덱스 구하기
			int max = 0;
			int index = -1;
			for(int k = 0; k < 4; k++) {
				if(count[k] > max) {
					max = count[k];
					index = k;
				}
			}
			
			bw.write(nucles[index]);
			hammingDistance += n-max;
		}
		
		bw.write("\n"+hammingDistance);
		bw.flush();
	}
}
