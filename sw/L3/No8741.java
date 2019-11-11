package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No8741 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			String word = br.readLine();
			String[] words = word.split(" ");
			String answer = "";
			for(int j = 0; j <words.length; j++) {
				answer = answer + words[j].substring(0,1).toUpperCase();
			}
			System.out.println("#"+(i+1)+" "+answer);
		}
	}
}
