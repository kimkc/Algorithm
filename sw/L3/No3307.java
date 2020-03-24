package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No3307 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testCase; i ++) {
			int num = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			
			ArrayList<Character> len = new ArrayList<Character>();
			len.add(nums.charAt(0));
			for(int j = 1; j < num; j++) {
				char next = nums.charAt(j*2);
				if(len.get(len.size()-1) < next) {
					len.add(next);
				}else  {
					int index = Collections.binarySearch(len, next);
					if(index < 0) {
						int realIndex = -index-1;
						len.remove(realIndex);
						len.add(realIndex, next);
					}
				}
			}
			System.out.println(len.size());
			
		}
	}
}
