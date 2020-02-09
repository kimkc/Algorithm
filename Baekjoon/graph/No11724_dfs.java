package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11724_dfs {
	static int vertaxNum;
	static int[][] adj;
	static boolean[] visited;
	
	public static void dfs(int v) {
		visited[v] = true;
		for(int i = 0; i < vertaxNum; i++) {
			if(adj[v][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertaxNum = Integer.parseInt(st.nextToken())+1;
		adj = new int[vertaxNum][vertaxNum];
		visited = new boolean[vertaxNum];
		int edgeNum = Integer.parseInt(st.nextToken());
		for(int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x][y] = 1;
			adj[y][x] =1;
		}
		int count = 0;
		
		for(int i = 1; i < vertaxNum;i++) {
			if(visited[i] == false) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
