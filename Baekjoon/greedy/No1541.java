package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String strNum = br.readLine();
		String[] strNums = strNum.split("\\+|\\-");
		char[] operator = new char[strNums.length-1];
		int j = 0;
		for(int i = 0; i < strNum.length(); i++) {
			if(strNum.charAt(i) == '+' || strNum.charAt(i) == '-') {
				operator[j] = strNum.charAt(i);
				j++;
			}
		}
		int sum = Integer.parseInt(strNums[0]);
		int i = 1;
		j = 0;
		while(i < strNums.length) { //strNum.length()로 혼란.. 이런 실수 하지말자. 명확한 이름정하기
			if(operator[j] == '+') {
				sum += Integer.parseInt(strNums[i]);
				i++;
				j++;
			}else if(operator[j] == '-'){
				int subSum = 0;
				subSum = Integer.parseInt(strNums[i]);
				while(j+1 < operator.length && operator[j+1] == '+') {
					// -일 때 그 다음 연산자(j+1)는 무엇인지 확인, -이면 while x, +이면 while문으로
					//처음 j++로 애매하게 함. 나도 명확히 어떻게 코드가 돌아가는지 설명할 수 있어야 버그를 없앨 수 있다.
					//12+34+24-45-76+34+35-76
					i++;
					subSum += Integer.parseInt(strNums[i]);
					j++;
				}
				sum -= subSum;
				j++;
				i++;
			}
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}
