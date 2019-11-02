package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No8338 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCaseNum; i++) {
			
			int testCaseLen = Integer.parseInt(br.readLine());
			int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int max = testCase[0];
			for(int j = 1; j < testCaseLen; j++) {

				int plus = max + testCase[j];
				int mul = max * testCase[j];
				if( plus >= mul ) {
					max = plus;
				}else {
					max = mul;
				}
			}
			System.out.println("#"+(i+1)+" "+max);
		}
	}
}


/*
public class No8338 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCaseNum; i++) {
		
			int testCase = Integer.parseInt(br.readLine());
			String[] testCases = br.readLine().split(" ");
			int max = Integer.parseInt(testCases[0]);
			
			for (int j = 1; j < testCase; j++) {
				if(j == 1 && (testCases[j-1].equals("1") || testCases[j-1].equals("0"))){
					max += Integer.parseInt(testCases[j]);
				}else if(testCases[j].equals("0") || testCases[j].equals("1")) {
					max += Integer.parseInt(testCases[j]);
				} else {
					max *=Integer.parseInt(testCases[j]);
				}
			}
			
			System.out.print("#"+(i+1)+" ");
			System.out.println(max);
		}
	}
}
*/