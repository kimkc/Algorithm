package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No7532 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		final int S = 365;
		final int E = 24;
		final int M = 29;
		for( int j = 0; j < testNum; j++) {
			
			int[] semsInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			long count = 0;
			int[] sems = {0,0,0};
			while(true) {
				count++;
				sems[0]++;
				sems[1]++;
				sems[2]++;
				/*
				if(sems[0] % S == 0) {
					sems[0] = 1;
				}
				if(sems[1] % E == 0) {
					sems[1] = 1;
				}
				if(sems[2] % M == 0) {
					sems[2] = 1; 시간 초과
				}
				 */
				if(sems[0] > S) {
					sems[0] = 1;
				}
				if(sems[1] > E) {
					sems[1] = 1;
				}
				if(sems[2] > M) {
					sems[2] = 1;
				}
				if(semsInput[0] == sems[0] && semsInput[1] == sems[1] && semsInput[2] == sems[2]) {
					break;
				}
			}
			System.out.println("#"+(j+1)+" "+count);
		}
	}
}
