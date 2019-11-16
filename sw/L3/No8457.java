package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No8457 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter( new OutputStreamWriter(System.out));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			int[] nTimeError = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] sandWatches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int count = 0;
			
			for(int j = 0; j < nTimeError[0]; j++) {
				int sandWatch = sandWatches[j];
				int increase = 1;
				while( nTimeError[1]+nTimeError[2] >= sandWatch*increase ) {
					if( (nTimeError[1]-nTimeError[2] <= sandWatch*increase) && (nTimeError[1]+nTimeError[2] >=sandWatch*increase)){
						count++;
						break;
					}
					increase++;
				}
			}
			
			wr.write("#"+(i+1)+" "+count+"\n");
			wr.flush();
		}
	}
}
