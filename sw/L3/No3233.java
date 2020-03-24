package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No3233 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testCase; i ++) {
			String[] aNb = br.readLine().split(" ");
			int a = Integer.parseInt(aNb[0]);
			int b = Integer.parseInt(aNb[1]);
			int height = a/b;
			
			int result  = 1;
			for(int j = 1; j < height; j++) {
				result += j+2;
			}
			System.out.println("#"+i+" "+result);
		}
	
	}
}
