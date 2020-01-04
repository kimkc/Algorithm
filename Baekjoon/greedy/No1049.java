package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[] needNbrandNum = br.readLine().split(" ");
		int needLine = Integer.parseInt(needNbrandNum[0]);
		int brandNum = Integer.parseInt(needNbrandNum[1]);
		int need6 = needLine/6;
		int need1 = needLine%6;
		int min6 = 100000;
		int min1 = 100000;
		
		for(int i = 0; i < brandNum;  i++) {
			String[] packNline = br.readLine().split(" ");
			int pack = Integer.parseInt(packNline[0]);
			int onlyLine = Integer.parseInt(packNline[1]);
			int packPrice = 0;
			int linePrice = 0;
			
			if(need6 > 0) {
				packPrice = pack;
				linePrice = onlyLine * 6;
				if(packPrice >= linePrice && linePrice < min6) {
					min6 = linePrice;
				}else if(packPrice < linePrice && packPrice < min6) {
					min6 = packPrice;
				}
			}
			packPrice = pack;
			linePrice = onlyLine * need1;
			if(packPrice >= linePrice && linePrice < min1) {
				min1 = linePrice;
			}else if(packPrice < linePrice && packPrice < min1) {
				min1 = packPrice;
			}
		}
		
		int result = min6*need6+min1;
		
		
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
