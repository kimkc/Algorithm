package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No5549 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			
			String testCase = br.readLine();
			int endNum = testCase.charAt(testCase.length()-1)-48;
			
			if (endNum % 2 ==0) {
				wr.write("#"+(i+1)+" Even"+"\n");
				wr.flush();
			}else {
				wr.write("#"+(i+1)+" Odd"+"\n");
				wr.flush();
				}
			}
		}
}
