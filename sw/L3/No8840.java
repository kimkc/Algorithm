package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No8840 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
		
			long L = Long.parseLong(br.readLine());
			
			wr.write("#"+(i+1)+" "+((L/2+1)*(L/2)-L/2)+"\n");
			wr.flush();
		}
	}
}
