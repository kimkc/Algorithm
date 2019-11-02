package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class No7728 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i=0; i<testCaseNum; i++) {

			HashSet<String> numSet = new HashSet<String>();
			
			String testCase = br.readLine();
			String[] testCase2array = testCase.split("");

			for(int j = 0; j < testCase2array.length; j++) {
				numSet.add(testCase2array[j]);
			}
			
			System.out.print("#"+(i+1)+" ");
			System.out.println(numSet.size());
		}
		
		
	}
}
