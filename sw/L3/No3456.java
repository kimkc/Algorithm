package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3456 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] edges = new int[3];
			for(int j = 0; j < 3; j++) {
				edges[j] = Integer.parseInt(st.nextToken());
			}
			int[] temp = new int[2];
			temp[0] = edges[0];
			for(int j = 1; j < 3; j++) {
				if(temp[0] != edges[j]) {
					temp[1] = edges[j];
				}
			}
			int sum;
			if(temp[1] == 0) {
				sum = temp[0]*4;
			}else {
				sum = temp[0]*2 + temp[1]*2;
			}
			sum = sum-edges[0]-edges[1]-edges[2];
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
}
