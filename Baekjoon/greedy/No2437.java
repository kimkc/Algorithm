package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2437 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sinkerNum = Integer.parseInt(br.readLine());
		int[] sinkers = new int[sinkerNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < sinkerNum; i++) {
			sinkers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sinkers);
		int sum = 1; //�ּ� �� ����, �Ŀ� sum+1���� ū ���ε� ������ �� �ִ�. �̺��� ũ�� �������� �ʴ´�. ��? ������ ���ؼ� ã�Ƴ� �� ����
		for(int i = 0; i < sinkerNum; i++) {
			if(sinkers[i] > sum) {
				break;
			}
			sum += sinkers[i];
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}	
}
		/*		
		boolean[] weights = new boolean[1000000000];
		int[] sinkers;
		int sinkerNum = Integer.parseInt(br.readLine());
		sinkers = new int[sinkerNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < sinkerNum; i++) {
			sinkers[i] = Integer.parseInt(st.nextToken());
			weights[sinkers[i]] = true;
		}
		Arrays.sort(sinkers);
		
		for(int i = 0; i < 1000000000; i++) {
			if(weights[i] == false) {
				//�ε��� ã�� �Լ� ����
				int index = 0;
				for(int j = 0; j < sinkerNum; j++) {
					if(i <= sinkers[j]) {
						index = j;
					}
				}
				//
				int[] subSinkers;
				if(index == 0) {
					subSinkers = Arrays.copyOf(sinkers, sinkerNum);
					
				}else {
					subSinkers = Arrays.copyOf(sinkers, index);
				}
				//�ش� �迭������ �κ����� ã�� �Լ�
				int subLen = subSinkers.length;
				for(int j = 0; j < (1 << subLen); j++) {
					int sum = 0;
					for(int k = 0; k < subLen; k++) {
						if( (j & (1 << k)) > 0) {
							sum += subSinkers[k];
						}
					}
					if(weights[sum] == false) {
						weights[sum] = true;
					}
					if(i == sum) {
						break;
					}
				}
				//
				if(weights[i] == false) {
					bw.write(String.valueOf(i));
					break;
				}
			}
		}
		
		bw.flush();
	}
}
*/