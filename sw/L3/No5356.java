package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No5356 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			
			String[] words = new String[5];
			int[] wordLen = new int[5];
			for(int j = 0; j < 5; j++) {
				words[j] = br.readLine();
				wordLen[j] = words[j].length();
			}
			
			int totalLen = Arrays.stream(wordLen).sum();
			System.out.print("#"+(i+1)+" ");
			int k = 0;
			while(totalLen != k) {
				for(int x = 0; x < 5; x++) {
					if(wordLen[x] > k) {
						System.out.print(words[x].charAt(k));
					}
				}
				k++;
			}
			System.out.println();
		}
	}
}
