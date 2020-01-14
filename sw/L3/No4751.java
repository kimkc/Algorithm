package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No4751 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void print1N5Line(int wordLen) throws IOException{
		for(int j = 0; j < wordLen; j++) {
			if(j == 0) {
				bw.write("..#..");	
			}else {
				bw.write(".#..");
			}
		}
		bw.write("\n");
	}
	
	static void print2N4Line(int wordLen) throws IOException{
		for(int j = 0; j < wordLen*2; j++) {
			if(j == 0) {
				bw.write(".#.");	
			}else {
				bw.write("#.");
			}
		}
		bw.write("\n");
	}
	
	public static void main(String[] args) throws IOException{
		
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			
			String words = br.readLine();
			int wordLen = words.length();
			if(wordLen==1) {
				bw.write("..#..\n"+".#.#.\n"+"#."+words+".#\n"+".#.#.\n"+"..#..\n");
				bw.flush();
			}else {
				print1N5Line(wordLen);
				print2N4Line(wordLen);
				for(int j = 0; j < words.length(); j++) {
					bw.write("#");	
					bw.write("."+words.charAt(j)+".");
				}
				bw.write("#\n");
				print2N4Line(wordLen);
				print1N5Line(wordLen);
				bw.flush();
				
			}
		
		}
	}
}
