package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No3975 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1; i <= testCase; i++) {	
			String result  = br.readLine();
			int alice = (result.charAt(0)-'0')*(result.charAt(6)-'0');
			int bob = (result.charAt(4)-'0')*(result.charAt(2)-'0');
			System.out.print("#"+i+" ");
			if(alice > bob) {
				System.out.println("ALICE");
			}else if(alice == bob){
				System.out.println("DRAW");		
			}
			else {	
				System.out.println("BOB");	
			}
			// 여기가 맞다 왜그런지 생각해봐라.. 논리는 맞는데 너무 쉽게 생각해서 어처구니 없는 실수를 했다..정신똑바로차리자
			//StringTokenizer st = new StringTokenizer(br.readLine());
			/*
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			a = a*d;
			b = b*c;
			*/
		}
	}
}
