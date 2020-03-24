package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No3142 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		

		for(int i = 1; i <= testCase; i ++) {
			String[] cornNbeast = br.readLine().split(" ");
            int corn = Integer.parseInt(cornNbeast[0]);
            int beast = Integer.parseInt(cornNbeast[1]);
			int unicorn, twinHorn;
			twinHorn = corn-beast;
			unicorn = beast-twinHorn;
			System.out.println("#"+i+" "+unicorn+" "+twinHorn);
		}	
	}
}
