package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No3032 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());

		for(int i = 1; i <= testCase; i ++) {
			String[] aNb = br.readLine().split(" ");
			long a = Long.parseLong(aNb[0]);
			long b = Long.parseLong(aNb[1]);
			
			if(a==b || a==1 || b==1) {
				System.out.println("#"+i+" -1");
				continue;
			}
			
			int j = 1;
			while( (a*j) % b != 1) {
				j++;
			}
			
			System.out.println("#"+i+" "+j+" -"+((a*j)/b));
		}
		
	}
}
