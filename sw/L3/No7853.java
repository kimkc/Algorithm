package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7853 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCaseNum; i++) {
			
			String[] testCase = br.readLine().split("");
			int numberOfCases = 0;
			long result = 1;
			for(int j = 0; j < testCase.length; j++) {
				
				if(j == 0) {
					if(testCase[j].equals(testCase[j+1])) {
						numberOfCases = 1;
					}else {
						numberOfCases = 2;
					}
				}else if( j == testCase.length-1) {
					if(testCase[j].equals(testCase[j-1])) {
						numberOfCases= 1;
					}else {
						numberOfCases = 2;
					}
				}else {
					if(testCase[j].equals(testCase[j-1]) && testCase[j].equals(testCase[j+1])) {
						numberOfCases = 1;
					}else if( (testCase[j].equals(testCase[j-1]) && !(testCase[j].equals(testCase[j+1]))) || (!(testCase[j].equals(testCase[j-1])) && testCase[j].equals(testCase[j+1])) ) {
						numberOfCases = 2;
					}else if(testCase[j-1].equals(testCase[j+1])){
						numberOfCases = 2;
					}else {
						numberOfCases = 3;
					}
				}
				result *= numberOfCases;
				result = result >= 1000000007 ? result % 1000000007 : result;
			}
			result %= 1000000007; 
			System.out.println("#"+(i+1)+" "+result);
		}
	}
}

/*
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCaseNum; i++) {
             
            String[] testCase = br.readLine().split("");
            long result = 1;
             
            if(testCase[0].equals(testCase[1])) {
                    result *= 1;
            }else {
                    result*= 2;
            }
             
            for(int j = 1; j < testCase.length-1; j++) {
                 
                    if(testCase[j].equals(testCase[j-1]) && testCase[j].equals(testCase[j+1])) {
                        result *= 1;
                    }else if( testCase[j].equals(testCase[j-1]) || testCase[j].equals(testCase[j+1]) || testCase[j-1].equals(testCase[j+1] )) {
                        result *= 2;
                    }else {
                        result *= 3;
                    }
                    result = result >= 1000000007 ? result % 1000000007 : result;
                }
             
                    if(testCase[testCase.length-1].equals(testCase[testCase.length-2])) {
                        result*= 1;
                    }else {
                        result*= 2;
                    }
             
            result %= 1000000007; 
            System.out.println("#"+(i+1)+" "+result);
            }
        }
    }
 */ 
