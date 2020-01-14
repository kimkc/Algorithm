package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No4466 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] scores = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				scores[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(scores);
			int sum = 0;
			for(int j = N-1; j >= N-K; j--) {
				sum += scores[j];
			}
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
}
