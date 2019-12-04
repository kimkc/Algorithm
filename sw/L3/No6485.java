package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No6485 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			int testCase = Integer.parseInt(br.readLine());
			int[] busStation = new int[5001];
			
			for(int j = 0; j < testCase; j++) {

				String[] busRoute = br.readLine().split(" ");
				int a= Integer.parseInt(busRoute[0]);
				int b= Integer.parseInt(busRoute[1]);
				for(int x=a; x<=b; x++) {
					busStation[x]++;
				}
			}
				
			int answerNum = Integer.parseInt(br.readLine());
				
			wr.write("#"+(i+1)+" ");
			for(int z = 0; z < answerNum; z++) {
				int curiousStation = Integer.parseInt(br.readLine());
				wr.write(busStation[curiousStation]+" ");
			}
			wr.write("\n");
			wr.flush();
			}
		}
}

