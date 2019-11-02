package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No6913 {

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			
			int[] peopleNproblem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] solveProblem = new int[peopleNproblem[0]];
			for(int x = 0; x < peopleNproblem[0]; x++) {
				int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for(int y = 0; y < peopleNproblem[1]; y++) {
					if(temp[y] == 1) {
						solveProblem[x]++;
					}
				}
			}
			
			int maxSolved = 0;
			for(int k = 0; k < solveProblem.length; k++) {
				if(maxSolved < solveProblem[k]) {
					maxSolved = solveProblem[k];
				}
			}
			
			int sameSolved = 0;
			for(int w = 0; w < solveProblem.length; w++) {
				if (maxSolved == solveProblem[w]) {
					sameSolved++;
				}
			}
			
			System.out.println("#"+(i+1)+" "+sameSolved+" "+maxSolved);
		}
	}
} 