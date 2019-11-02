package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No7987 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			
			HashMap<Character, Integer> alphaNcount = new HashMap<Character, Integer>();
			int testCaseLen = Integer.parseInt(br.readLine());
			int count = 0;
			for(int j = 0; j < testCaseLen; j++) {
				
				char titleFirst = br.readLine().charAt(0);
				alphaNcount.put(titleFirst, 1);
			}
			
			for(int k = 65; k < 91; k++) {
				try {
					if(alphaNcount.get((char)k) == 1) {
						count++;
					}else {
						break;
					}
				}catch(Exception e) {
					break;
				}
			}
			System.out.println("#"+(i+1)+" "+count);
		}
	}
}
