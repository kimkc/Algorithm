package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No8673 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter( new OutputStreamWriter(System.out));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			int testCase = Integer.parseInt(br.readLine());
			int[] persons = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int forNum = persons.length;
			int sum = 0;
			
			for(int j = 0; j < testCase; j++) {
				
				for(int k = 0; k < forNum; k += 2) {
					if(persons[k]-persons[k+1] == 0) {
						sum += 0;
						persons[k/2] = persons[k];
					}else {
						sum += Math.abs(persons[k]-persons[k+1]);
						persons[k/2] = persons[k]>persons[k+1] ? persons[k] : persons[k+1];
					}
				}
				forNum /= 2;
			}
			
			wr.write("#"+(i+1)+" "+sum+"\n");
			wr.flush();
		}
	}
}
