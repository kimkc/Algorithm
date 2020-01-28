package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2178_bfs {
	static int n;
	static int m;
	//static int min = 5050;
	static char[][] maze;
	static int[][] count;
	static int[][] xNy = {{-1,0},
			  {1, 0},
			  {0,-1},
			  {0,1}};
	
	public static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		while(!q.isEmpty()) {
			Dot dot = q.poll();
			for(int i = 0; i < 4; i++) {
				int newX = dot.x+xNy[i][0];
				int newY = dot.y+xNy[i][1];
				if( n > newX && newX >=0 && m > newY && newY >= 0) {
					
					if( maze[newX][newY] == '1') {
						maze[newX][newY] = '0';
						count[newX][newY] = count[dot.x][dot.y]+1;
						q.add(new Dot(newX, newY));
					}	
				}
			}
		}
		
	}
	/*
	public static void dfs(int x, int y, int count) {
		if(x == n-1 && y == m-1 && min > count) {
			min = count;
		}
		for(int i = 0; i < 4; i++) {
			int newX = x+xNy[i][0];
			int newY = y+xNy[i][1];
			if( n > newX && newX >=0 && m > newY && newY >= 0) {
				
				if( maze[newX][newY] == '1' ) {
					maze[newX][newY] = '0';
					dfs(newX,newY, count+1);
					maze[newX][newY] = '1';
				}	
			}
		}
	} why? O()
	*/ 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new char[n][m];
		count = new int[n][m];
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {
				maze[i][j] = row.charAt(j);
			}
		}
		maze[0][0] = '0';
		count[0][0] = 1;
		bfs(0,0);
		bw.write(String.valueOf(count[n-1][m-1]));
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(count[i][j]);
			}
			System.out.println();
		}
		//dfs(0,0,1);
		//bw.write(String.valueOf(min));
		bw.flush();
	}
}

class Dot{
	int x;
	int y;
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
