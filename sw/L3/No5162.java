package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No5162 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			String[] AnBnC = br.readLine().split(" ");
			int pumpkinPrice = Integer.parseInt(AnBnC[0]);
			int ricePrice= Integer.parseInt(AnBnC[1]);
			int price = Integer.parseInt(AnBnC[2]);
			int count = 0;
			int remainder = 0;
			
			
			if(ricePrice >= pumpkinPrice) {
				count = price/pumpkinPrice;
				remainder = price % pumpkinPrice;
				count += remainder/ricePrice;
			}else {
				count = price/ricePrice;
				remainder = price % ricePrice;
				count += remainder/pumpkinPrice;
			}
			bw.write("#"+(i+1)+" "+count+"\n");
			bw.flush();
		}
	}
}
