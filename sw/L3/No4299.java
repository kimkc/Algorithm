package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4299 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		int sum;
		int beforeMin = 16511;
		for(int i = 1; i <= testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sum = Integer.parseInt(st.nextToken())*24*60+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken())-beforeMin;
			if(sum>=0) {
				System.out.println("#"+i+" "+sum);
			}else
				System.out.println("#"+i+" -1");
		}
		
	
	}
}
