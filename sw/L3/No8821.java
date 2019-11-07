package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class No8821 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			String num = br.readLine();
			char[] counts = new char[10];
			int leftCount = 0;
			
			for(int j = 0; j < num.length(); j++) {
				counts[num.charAt(j)-'0']+=1; 
			}
			
			for(int k = 0; k < counts.length; k++) {
				if (counts[k] % 2 == 1) {
					leftCount++;
				}
			}
			System.out.println("#"+(i+1)+" "+leftCount);
		}
	}
}
