package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No6730 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			short blockNum = Short.parseShort(br.readLine());
			short maxAsc = 0;
			short maxDesc = 0;
			String[] blocks = br.readLine().split(" ");
			for(int j = 1; j <blockNum; j++) {
				short nowBlock = Short.parseShort(blocks[j-1]);
				short nextBlock = Short.parseShort(blocks[j]);
				short difficulty = (short)(nowBlock-nextBlock);
				
				if(difficulty > 0 && difficulty > maxDesc) {
					maxDesc = difficulty;
				}else if(difficulty < 0 && Math.abs(difficulty) > maxAsc) {
					maxAsc = (short)Math.abs(difficulty);
				}
				
			}
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(i+1).append(" ").append(maxAsc).append(" ").append(maxDesc).append("\n");
			
			bw.write(sb.toString());
			bw.flush();
		}	
	}
}

