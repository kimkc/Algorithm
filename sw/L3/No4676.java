package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No4676 {


	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			bw.write("#"+(i+1)+" ");
			char[] str = br.readLine().toCharArray();
			int hyphNum = Integer.parseInt(br.readLine());
			int[] hyphLoc = new int[hyphNum];
			String[] strHyphLoc = br.readLine().split(" ");
			for(int j = 0; j < hyphNum; j++) {
				hyphLoc[j] = Integer.parseInt(strHyphLoc[j]);
			}
			Arrays.sort(hyphLoc);
			StringBuffer sb = new StringBuffer();
			int hyphIndex = 0;
			int strIndex = 0;
			for(int j = 0; j < str.length; j++ ) {
			 //str 인덱스와 hyphen 위치와 같아서 앞 쪽에  출력하는 경우만
				while(hyphIndex < hyphNum && j == hyphLoc[hyphIndex]) {
					bw.write("-");
					hyphIndex++;
				}
				if(hyphIndex < hyphNum && j <= hyphLoc[hyphIndex]){
					bw.write(str[j]);
					strIndex++;
				}
			}
			while(hyphIndex < hyphNum) { //str.length보다 +1  위치의 hyphen을 출력.
				bw.write("-");
				hyphIndex++;
			}
			while(strIndex < str.length) { //hoi 3 0 0 0 같은 경우 출력못한 문자열 출력
				bw.write(str[strIndex]);
				strIndex++;
			}
			bw.flush();
			/*
			int x = 0;
			int k = 0;
			for(int j = 0; j < str.length; j++ ) {
				while(x < highNum && highLoc[x] <= j) {
					bw.write("-");
					x++;
				}
				bw.flush();
				if(j < highNum) { //이부분이 틀림의 원인 일 것 같다. 
					bw.write(str[j]);
					k++;
				}
			}
			while(k < str.length) { //이것과 밑의 순서도 원인 일 수 있으려나
				bw.write(str[k]);
				k++;
			}
			while(x < highNum) {
				bw.write("-");
				x++;
			}
			bw.write("\n");
			bw.flush();
			*/
		}	
	}
}
