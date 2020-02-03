package Baekjoon.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * �ƽ�Ű �ڵ� 97-122 �ε������� false�� �����صд�. 
 * ���ڸ� ������ �ش� �ε����� true���� Ȯ�� �� false��� true�� �ٲٰ� char ������ ���� ��, char�� �ٸ� ���ڸ� ���� ������ ���ڿ� �ε����� �Ѿ��. 
 * �ٸ� ���ڸ� ������ �ش� �ε����� �߰��ϰ� char�� ������ ���� ���� ������ �ݺ��Ѵ�.
 * �̶� true�� �Ǿ��ִٸ� break�� �Ѵ�. ���� ������ break���� ���ٸ� count�� 1 �ø���.
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
