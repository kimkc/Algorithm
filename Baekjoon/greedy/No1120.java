package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1120 {

	public static void main(String[] arg) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] aNb = br.readLine().split(" ");
		int aLen = aNb[0].length();
		int bLen = aNb[1].length();
		int min = 50;
		int diffCount = 0;
		
		if(aLen - bLen == 0) {
			for(int i = 0; i < aLen; i++) {
				if(aNb[0].charAt(i) != aNb[1].charAt(i)) {
					diffCount++;
				}
				min = diffCount;
			}
		}else {
			for(int i = 0; i <= bLen - aLen; i++) {
				diffCount = 0;
				String tempB = aNb[1].substring(i, i+aLen);
				for(int j = 0; j < aLen; j++) {
					if(aNb[0].charAt(j) != tempB.charAt(j)) {
						diffCount++;
					}
				}
				if(min > diffCount) {
					min = diffCount;
				}
			}
		}
		bw.write(String.valueOf(min));
		bw.flush();
	}
}
