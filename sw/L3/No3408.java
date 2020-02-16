package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class No3408 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1; i <= testCase; i++) {
			long n = Long.parseLong(br.readLine());
			bw.write("#"+i+" "+(n*(n+1)/2)+" ");
			bw.write(n*n+" ");
			bw.write(n*(n+1)+"\n");
			bw.flush();
		}
	}
}
