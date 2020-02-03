package Baekjoon.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * B배열은 그대로여야 하지만 A의 수를 재배열 할 수 있기 때문에
 * 무엇이로든 A의 배열은 변할 수 있다. 최소값이 나오려면 A의 최솟값과 최댓값 곱해지고 그 다음 최솟값과 최댓값이 곱해져서 더해지는 과정이면 된다.
 * A는 무슨 배열로든 배열될 수 있으므로 배열이 안되는 B의 최대값과 최솟값, 그다음 최대값과 a의 최솟값끼리 되도록 묶어준다. B는 출력할 없으니 a,b 둘 대 정렬 후 하나는 차례로 하나는 반대로 최소, 최대값들을 곱하고 더해주면 된다.
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
