package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No8658 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter( new OutputStreamWriter(System.out));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			
			String[] num = br.readLine().split(" ");
			int max = 1;
			int min = 1000000;
			
			for(int j = 0; j < 10; j++) {
				int sum = 0;
				
				for(int k = 0;  k < num[j].length(); k++) {
					sum += num[j].charAt(k)-48;
				}
				
				if( sum > max) max = sum;
				if( sum < min) min = sum;	
			}
			
			wr.write("#"+(i+1)+" "+max+" "+min+"\n");
			wr.flush();
		}
	}
}

