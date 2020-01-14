package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No4579 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testNum; i++) {
			StringBuffer sb = new StringBuffer();
			String pattern = br.readLine();
			char[] patterns = pattern.toCharArray();
			int patternLen = patterns.length;
			boolean isExist = true;
			if(!pattern.contains("*")) {
				for(int j = 0; j < patternLen; j++) {
					if(patterns[j] != patterns[patternLen-j-1]) {
						isExist = false;
						break;
					}
				}
			}else {
				for(int j = 0; j < patternLen; j++) {
					if(patterns[j]  == '*' || patterns[patternLen-j-1]  == '*' ) {
						break;
					}
					if(patterns[j] != patterns[patternLen-j-1]) {
						isExist = false;
						break;
					}
				}
			}
			
			  if(isExist) {
	            	sb.append("#"+(i+1)+" Exist\n");
	            }else {
	            	sb.append("#"+(i+1)+" Not exist\n");
	            }
			  	bw.write(sb.toString());
			  	bw.flush();
		}
	}
}
