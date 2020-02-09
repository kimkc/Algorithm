package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No3499 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testCase; i++) {	
			int cardNum = Integer.parseInt(br.readLine());
			String[] cards = new String[cardNum];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < cardNum; j++) {
				cards[j] = st.nextToken();
			}
			int frontEnd = cardNum/2;
			if(cardNum % 2 == 1) {
				frontEnd = cardNum/2+1;
			}
			int front = 0; int back = frontEnd;
			bw.write("#"+i+" ");
			while(front != frontEnd) {
				bw.write(cards[front]+" ");
				front++;
				if(back < cardNum) {
					bw.write(cards[back]+" ");
					back++;
				}
			}
			bw.write("\n");
			bw.flush();
		}
	}
}
