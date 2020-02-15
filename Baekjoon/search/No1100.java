package Baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String board;
		int count = 0;
		for(int i = 0; i < 8; i++) {
			board = br.readLine();
			if(i%2 == 0) {
				for(int j = 0; j < 4; j++) {
					if(board.charAt(j*2) == 'F') {
						count++;
					}
				}
			}else {
				for(int j = 1; j < 8; j+=2) {
					if(board.charAt(j) == 'F') {
						count++;
					}
				}
			}
			
		}
		System.out.println(count);		
	}
}
