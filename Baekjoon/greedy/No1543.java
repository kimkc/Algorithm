package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No1543 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String docs = br.readLine();
		String words = br.readLine();
		int docsLen = docs.length();
		int max = 0;

		for(int i = 0; i < docsLen; i++) {
			int j = i;
			int count = 0;
		
			while(j < docsLen) {
				boolean isWord = true;
				if(words.charAt(0) == docs.charAt(j)) {
					for(int k = 1; k < words.length(); k++) {
						if(j+k >= docsLen) {
							isWord = false;
							break;
						}
						if(words.charAt(k) != docs.charAt(j+k)) {
							isWord = false;
							break;
						}
					}
					if(isWord) {
						j +=words.length();
						count++;
						continue;
					}
				}
				j++;
			}
			if (count > max) {
				max = count;
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
	}
}
