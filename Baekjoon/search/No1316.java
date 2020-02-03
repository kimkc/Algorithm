package Baekjoon.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 아스키 코드 97-122 인덱스값으 false로 저장해둔다. 
 * 문자를 만나면 해당 인덱스가 true인지 확인 후 false라면 true로 바꾸고 char 변수에 저장 후, char와 다른 문자를 만날 때까지 문자열 인덱스를 넘어간다. 
 * 다른 문자를 만나면 해당 인덱스를 추가하고 char에 대입후 위와 같은 과정을 반복한다.
 * 이때 true가 되어있다면 break를 한다. 만약 끝까지 break없이 간다면 count를 1 올린다.
 */
public class No1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		int count = testNum ;
		
		for(int i = 0; i < testNum; i++) {
			boolean[] isExist = new boolean[123];
			char nowChar = '0';
			char[] words = br.readLine().toCharArray();
			
			int wordsLen = words.length;
			for(int j = 0; j < wordsLen; j++) {
				if(nowChar == words[j]) {
					continue;
				}else if(isExist[words[j]] == false) {
					isExist[words[j]] = true;
					nowChar = words[j];
				}else if(isExist[words[j]] == true) {
					count--;
					break;
				}
			}
		}
		
		bw.write(String.valueOf(count));
		bw.flush();

	}
}
