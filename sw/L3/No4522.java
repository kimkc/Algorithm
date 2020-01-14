package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No4522 {
	public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] patterns = br.readLine().toCharArray();
            int patternLen = patterns.length;
			boolean isExist = true;
            for(int i = 0; i < patternLen/2; i++) {
            	if(patterns[i] != patterns[patternLen-i-1] && patterns[i] != '?' && patterns[patternLen-i-1] != '?') {
            		isExist = false;
            		break;
            	}	
            }
            if(isExist) {
            	bw.write("#"+test_case+" Exist\n");
                bw.flush();
            }else {
            	bw.write("#"+test_case+" Not exist\n");
                bw.flush();
            }			
		}
	}
}
