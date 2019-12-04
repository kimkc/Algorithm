package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No6019 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			float answer = 0;
			String[] testCase = br.readLine().split(" ");
			float betweenTrain = Integer.parseInt(testCase[0]);
			int trainA = Integer.parseInt(testCase[1]);
			int trainB = Integer.parseInt(testCase[2]);
			int fly = Integer.parseInt(testCase[3]);
			
			float conflictTime = betweenTrain/(trainA+trainB);
			answer = fly*conflictTime;
			wr.write("#"+(i+1)+" "+answer+"\n");
			wr.flush();
			}
		}
}
