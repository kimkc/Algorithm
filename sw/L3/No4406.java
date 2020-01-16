package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No4406 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			char[] str = br.readLine().toCharArray();
			System.out.print("#"+(i+1)+" ");
			for(int j = 0; j < str.length; j++) {
				if(str[j] != 'a' && str[j] != 'e' && str[j] != 'i' && str[j] != 'o' && str[j] !='u') {
					System.out.print(str[j]);
				}
			}
			System.out.println();
		}
	}
}
