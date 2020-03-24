package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] sizes = br.readLine().split(" ");
		int screenSize = Integer.parseInt(sizes[0]);
		int basketSize = Integer.parseInt(sizes[1]);
		int distance = 0;
		int basketL = 1;
		int basketR = basketSize;
		
		int appleNum = Integer.parseInt(br.readLine());
		int loc;
		
		for(int i = 0; i < appleNum; i++) {
			loc = Integer.parseInt(br.readLine());
			if( basketL <= loc && loc <= basketR ) {
				continue;
			}else if( loc > basketR ) {
				basketL += loc - basketR;
				distance += loc - basketR;
				basketR = loc;
			}else if( loc < basketL ) {
				basketR -= basketL-loc;
				distance += basketL-loc;
				basketL = loc;
			}
		}
		
		System.out.println(distance);
		
	}
}
