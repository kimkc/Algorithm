package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No3431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1; i <= testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 int L = Integer.parseInt(st.nextToken());
			 int U = Integer.parseInt(st.nextToken());
			 int x = Integer.parseInt(st.nextToken());
			 bw.write("#"+i+" ");
			 if(L > x) {
				 bw.write(L-x+"\n");
			 }else if(U < X) {
				 bw.write("-1\n");
			 }else {
				 bw.write("0\n");
			 }
			 bw.flush();
		}
	}
}
