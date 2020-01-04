package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No5215 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			
			String[] numNLimitCal = br.readLine().split(" ");
			int num = Integer.parseInt(numNLimitCal[0]);
			int limitCal = Integer.parseInt(numNLimitCal[1]);
			
			short[] scoreNcal = new short[num*2];
			for(int j = 0; j < num*2; j+=2){
				String[] input = br.readLine().split(" ");
				scoreNcal[j] = Short.parseShort(input[0]);
				scoreNcal[j+1] = Short.parseShort(input[1]);
			}
			
			int maxScore = 0;
			for(int x = 0; x < (1 << num); x++) {
				int sumCal = 0;
				int score = 0;
				for (int y = 0; y < num; y++) {
					if(((x & (1 << y)) > 0)) {
						
						sumCal += scoreNcal[(y*2)+1];
						
						if( sumCal <= limitCal)
							score += scoreNcal[y*2];
					}
				}
				
				if (score > maxScore) {
					maxScore= score;
				}
			}
			
			wr.write("#"+(i+1)+" "+maxScore+"\n");
			wr.flush();
		}
	}
}
