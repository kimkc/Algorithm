package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class No6692 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			int testCase = Integer.parseInt(br.readLine());
			float sum = 0;
			
			for(int j = 0; j < testCase; j++) {
				String[] input = br.readLine().split(" ");
				sum += Float.parseFloat(input[0])*Float.parseFloat(input[1]);
			}
		
			System.out.println("#"+(i+1)+" "+String.format("%.6f",sum));
		}
	}
}
