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
		while(i < strNums.length) { //strNum.length()�� ȥ��.. �̷� �Ǽ� ��������. ��Ȯ�� �̸����ϱ�
			if(operator[j] == '+') {
				sum += Integer.parseInt(strNums[i]);
				i++;
				j++;
			}else if(operator[j] == '-'){
				int subSum = 0;
				subSum = Integer.parseInt(strNums[i]);
				while(j+1 < operator.length && operator[j+1] == '+') {
					// -�� �� �� ���� ������(j+1)�� �������� Ȯ��, -�̸� while x, +�̸� while������
					//ó�� j++�� �ָ��ϰ� ��. ���� ��Ȯ�� ��� �ڵ尡 ���ư����� ������ �� �־�� ���׸� ���� �� �ִ�.
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
