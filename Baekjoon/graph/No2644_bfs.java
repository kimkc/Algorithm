package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No2644_bfs {
	static int[][] adj;
	static int vertax;
	static boolean[] visited;
	
	static int bfs(int start, int end) {
		int[] distance = new int[vertax+1];
		visited[start] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for(int i = 1; i <= vertax; i++) {
				if(adj[v][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
					distance[i] = distance[v]+1;
					if(i == end) {
						return distance[i];
					}
				}
			}
		}
		return -1;
	}
	
	static public void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		vertax = Integer.parseInt(br.readLine());
		adj = new int[vertax+1][vertax+1];
		visited = new boolean[vertax+1];
		String[] startNend = br.readLine().split(" ");
		int edge = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < edge; i++) {
			String[] parentNchild = br.readLine().split(" ");
			adj[Integer.parseInt(parentNchild[0])][Integer.parseInt(parentNchild[1])] = 1;
			adj[Integer.parseInt(parentNchild[1])][Integer.parseInt(parentNchild[0])] = 1;			
		}
		
		System.out.println(bfs(Integer.parseInt(startNend[0]), Integer.parseInt(startNend[1])));
	}
}
