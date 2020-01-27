package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260_dfsbfs {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] adj;
	static boolean[] visited;
	static int vertax;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void dfs(int v) throws IOException {
		visited[v] = true;
		
		for(int i = 0; i < vertax; i++) {
			if(adj[v][i] == 1 && !visited[i]) {
				bw.write(i+" ");
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) throws IOException{
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int nowVertax = queue.poll();
			for(int i = 0; i < vertax; i++) {
				if(adj[nowVertax][i] == 1 && !visited[i]) {
					visited[i] = true;
					bw.write(i+" ");
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertax = Integer.parseInt(st.nextToken())+1;
		int edgeNum = Integer.parseInt(st.nextToken());
		int startVertax = Integer.parseInt(st.nextToken());
		
		adj = new int[vertax][vertax];
		visited = new boolean[vertax];
		
		for(int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int fromV = Integer.parseInt(st.nextToken());
			int toV = Integer.parseInt(st.nextToken());
			adj[fromV][toV] = 1;
			adj[toV][fromV] = 1;
		}
		bw.write(String.valueOf(startVertax)+" ");
		dfs(startVertax); // 순서대로 출력하기 위하여, 먼저 하면 visited를 통해 이미 방문되기에 그다음 처음부터 순서대로 실행해주면 될 것 같다?
		//for(int i = 1; i < vertax; i++) {
			//dfs(i);  ==>왜 해주었는지 내가 어떤 착각을 햇는지 생각해보기
						//아마도 전에 정점들위주가 아닌 굳이 말하자면 간선들(지점)들을 위주의 dfs,bfs를 사용햇을 때 필요했었다. 그때는 왜 이것이 필요하고 여기는 왜 필요하지 않은가?
		//}
		bw.flush();
		
		bw.write("\n"+String.valueOf(startVertax)+" ");
		for(int i = 0; i < vertax; i++) {
			visited[i] = false;
		}
		bfs(startVertax);
		bw.flush();
	}
}
