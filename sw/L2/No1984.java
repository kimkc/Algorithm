package L2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No1984 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCaseNum; i++) {
			String[] testCaseTemp = br.readLine().split(" ");
			ArrayList<Integer> testCase = new ArrayList<Integer>();
			for(int k = 0; k < testCaseTemp.length; k ++) {
				testCase.add(Integer.parseInt(testCaseTemp[k]));
			}
			
			int testMax = Collections.max(testCase);
			int testMin = Collections.min(testCase);
			int testMidSum = (testCase.parallelStream().mapToInt(Integer::intValue).sum()) - testMax -testMin;
			long testMidAverage = Math.round(testMidSum/8.0); 
			//틀린 이유 int testMidAverage = Math.round(testMidSum/8); 
			
			System.out.print("#" + (i+1) + " ");
			System.out.println(testMidAverage);
		}
	}
}
