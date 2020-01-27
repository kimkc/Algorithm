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
		dfs(startVertax); // ������� ����ϱ� ���Ͽ�, ���� �ϸ� visited�� ���� �̹� �湮�Ǳ⿡ �״��� ó������ ������� �������ָ� �� �� ����?
		//for(int i = 1; i < vertax; i++) {
			//dfs(i);  ==>�� ���־����� ���� � ������ �޴��� �����غ���
						//�Ƹ��� ���� ���������ְ� �ƴ� ���� �����ڸ� ������(����)���� ������ dfs,bfs�� ������� �� �ʿ��߾���. �׶��� �� �̰��� �ʿ��ϰ� ����� �� �ʿ����� ������?
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
