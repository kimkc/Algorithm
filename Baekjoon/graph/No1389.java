package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1389 {
	static int n;
	static int[][] adj;
	
	static int bfs(int v) {
		int[] distance = new int[n];
		int numOfkevin = 0;
		boolean[] visited = new boolean[n];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[v] = true;
		q.add(v);
		
		while(!q.isEmpty()) {
			int vertax = q.poll();
			
			for(int i = 1; i < n; i++) {
				if(adj[vertax][i] == 1 && visited[i] == false) {
					visited[i] = true;
					q.add(i);
					distance[i] = distance[vertax]+1;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			numOfkevin += distance[i];
		//	System.out.println(distance[i]);
		}
		
		return numOfkevin;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = 100; 
		int result = 0;
		n = Integer.parseInt(st.nextToken())+1;
		int edge = Integer.parseInt(st.nextToken());
		adj = new int[n][n];
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[v][w] = 1;
			adj[w][v] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			int temp = bfs(i);
			System.out.println(i+" "+temp);
			if(min > temp) {
				min = temp;
				result = i;
			}
		}
		
		System.out.println(result);
	}
}
