package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No8931 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			int testCase = Integer.parseInt(br.readLine());
			ArrayList<Integer> bill = new ArrayList<Integer>();
			long sum = 0;
			
			for( int j = 0; j < testCase; j++) {
				int price = Integer.parseInt(br.readLine());
				if (price != 0) {
					bill.add(price);
					sum += price;
				} else {
					sum -= bill.remove(bill.size()-1);
				}
			}
			
			wr.write("#"+(i+1)+" "+sum+"\n");
			wr.flush();
		}
	}
}
