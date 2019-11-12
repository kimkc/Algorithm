package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No8556 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter( new OutputStreamWriter(System.out));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			String dir = br.readLine();
			int beforeTop = 0;
			int beforeBottom = 1;
			
			if (dir.length() == 5) {
				wr.write("#"+(i+1)+" "+0+"\n");
				wr.flush();
			}else if(dir.length() == 4) {
				wr.write("#"+(i+1)+" "+90+"\n");
				wr.flush();
			}else {
				int j = dir.length()-1;
				int expo = 1;
			
				if(dir.charAt(j) == 't') {
					beforeTop = 90;
					j -= 4;
				}else {
					beforeTop = 0;
					j -= 5;
				}
				
				while(j > 0) {
					if(dir.charAt(j) == 't') {
						int bottom = 2*expo;
						beforeTop = beforeTop * 2+90;
						//beforeTop = beforeTop * (bottom/beforeBottom)+90;
						beforeBottom = bottom;
						j -= 4;
						expo *= 2;
					}else {
						int bottom = 2*expo;
						beforeTop = beforeTop * 2-90;
						//beforeTop = beforeTop * (bottom/beforeBottom)-90; //()대신 2를 해도될듯, 많이 해보면 규칙 발견될듯 
						beforeBottom = bottom;
						j -= 5;
						expo *= 2;
					}
				}
				
				while(beforeTop %2 ==0 && beforeBottom %2 == 0) {
					beforeTop /= 2;
					beforeBottom /= 2;
				}
				if( beforeBottom == 1) {
					wr.write("#"+(i+1)+" "+ beforeTop+"\n");
					wr.flush();
				}else {
					wr.write("#"+(i+1)+" "+ beforeTop+"/"+beforeBottom+"\n");
					wr.flush();
				}
			}
		}
	}
}
