package Baekjoon.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * B�迭�� �״�ο��� ������ A�� ���� ��迭 �� �� �ֱ� ������
 * �����̷ε� A�� �迭�� ���� �� �ִ�. �ּҰ��� �������� A�� �ּڰ��� �ִ� �������� �� ���� �ּڰ��� �ִ��� �������� �������� �����̸� �ȴ�.
 * A�� ���� �迭�ε� �迭�� �� �����Ƿ� �迭�� �ȵǴ� B�� �ִ밪�� �ּڰ�, �״��� �ִ밪�� a�� �ּڰ����� �ǵ��� �����ش�. B�� ����� ������ a,b �� �� ���� �� �ϳ��� ���ʷ� �ϳ��� �ݴ�� �ּ�, �ִ밪���� ���ϰ� �����ָ� �ȴ�.
 */

public class No1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int len = Integer.parseInt(br.readLine());
		String[] strA = br.readLine().split(" ");
		String[] strB = br.readLine().split(" ");
		int sum = 0;
		
		int[] a = new int[len];
		int[] b = new int[len];
		
		for(int i = 0; i < len; i++) {
			a[i] = Integer.parseInt(strA[i]);
			b[i] = Integer.parseInt(strB[i]);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i = 0; i < len; i++) {
			sum += a[i]*b[len-i-1];
			}
		
		bw.write(String.valueOf(sum));
		bw.flush();

	}
}
