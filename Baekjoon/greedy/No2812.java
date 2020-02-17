package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String num = br.readLine();
		
		ArrayList<Integer> stack = new ArrayList<Integer>();
		stack.add(num.charAt(0)-'0');
		
		for(int i = 1; i < n; i++) {
			if(num.charAt(i) <= stack.get(stack.size()-1)) {
				stack.add(num.charAt(i)-'0');
			}else {
				if(k == 0) { //k=0이고, n은 안 끝났을 때
					stack.add(num.charAt(i)-'0');
				}
				while(k > 0) {
					if(stack.get(stack.size()-1) < num.charAt(i)-'0') {
						stack.remove(stack.size()-1);
						k--;
						if(stack.isEmpty()) {
							stack.add(num.charAt(i)-'0');
							break;
						}
						if(k == 0) {
							stack.add(num.charAt(i)-'0');
						}
					}else {
						stack.add(num.charAt(i)-'0');
						break;
					}
				}
			}
		}
		while(k > 0) {  //54321같은 경우 k가 하나도 안 줄었을 시
			stack.remove(stack.size()-1);
			k--;
		}
		for(int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i));
		}
	}
}
