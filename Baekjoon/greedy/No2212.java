package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class No2212 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		String[] strLoc = br.readLine().split(" ");
		int[] loc = new int[n]; 
		
		for(int i = 0; i < n; i++) {
			loc[i] = Integer.parseInt(strLoc[i]);
		}
		Arrays.sort(loc);
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); 
		for(int i = 0; i < n-1; i++) {
			pQ.add(Math.abs(loc[i]-loc[i+1]));	
		}
		
		for(int i = 0; i < k-1; i++) {
			pQ.poll();
		}
		
		System.out.println(pQ.stream().mapToInt(Integer::intValue).sum());
		
		
		
		
		
		
	}
}
