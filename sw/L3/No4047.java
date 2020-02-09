package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No4047 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1; i <= testCase; i++) {
			boolean[][] sdhc = new boolean[4][14];
			String s = br.readLine();
			int[] sum = new int[4];
			boolean isError = false;
			for(int j = 0; j < s.length()-2; j+=3) {
				int index = (s.charAt(j+1)-'0')*10+(s.charAt(j+2)-'0');
				if(s.charAt(j) == 'S') {
					if(sdhc[0][index] == true) {
						isError = true;
						break;
					}
					sdhc[0][index] = true;	
					sum[0]++;
				}else if(s.charAt(j) == 'D') {
					if(sdhc[1][index] == true) {
						isError = true;
						break;
					}
					sdhc[1][index] = true;	
					sum[1]++;	
				}else if(s.charAt(j) == 'H') {
					if(sdhc[2][index] == true) {
						isError = true;
						break;
					}
					sdhc[2][index] = true;	
					sum[2]++;	
				}else {
					if(sdhc[3][index] == true) {
						isError = true;
						break;
					}
					sdhc[3][index] = true;	
					sum[3]++;	
				}
			}
			System.out.print("#"+i+" ");
			if (isError) {
				System.out.println("ERROR");
			}else {
				for(int j = 0 ; j < 4; j++) {
					System.out.print((13-sum[j])+" ");
				}
			}
			System.out.println();
		}
	}
}

