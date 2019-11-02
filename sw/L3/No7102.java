package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No7102 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			int[] countProbability = new int[41];
			
			int[] nNm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int x = 1; x < nNm[0]+1; x++) {
				for(int y = 1; y < nNm[1]+1; y++) {
					countProbability[x+y]++;
				}
			}
			
			int max = 0;
			for(int j = 2; j < countProbability.length; j++) {
				if(countProbability[j] > max) {
					max = countProbability[j];
				}
			}
			
			System.out.print("#"+(i+1)+" ");
			for(int k = 2; k < countProbability.length; k++) {
				if(countProbability[k] == max) {
					System.out.print(k+" ");
				}
			}
			System.out.println();
		}
	}
}
