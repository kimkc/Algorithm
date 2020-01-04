package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BNo10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String strNum = br.readLine();
		if(!strNum.contains("0")) {
			bw.write("-1\n");
			bw.flush();
		}else {
			char[] nums = strNum.toCharArray();
			int sum = 0;
			for(int i = 0; i < nums.length; i++){
				sum += (nums[i]-'0');
			}
			if( sum % 3 == 0) {
				Arrays.sort(nums);
				for(int i = nums.length-1; i > -1; i--) {
					bw.write(nums[i]);
					bw.flush();
				}
			}else {
				bw.write("-1\n");
				bw.flush();
			}
		}
		
		/*
		for(int i = 0;  i < 1000; i++) {
			int basu = 0;
			String num = String.valueOf(i*30);
			for(int j = 0;  j < num.length(); j++) {
				basu += (num.charAt(j)-'0');
			}
			//System.out.println(num);
			if(basu % 3 != 0) {
				System.out.println("F");
			}
			if(i == 999) {
				System.out.println("end");
			}
		}*/
	}
}
