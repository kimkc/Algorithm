package Baekjoon.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10026_dfs {
	static char[][] grids;
	static boolean[][] visited;
	static int n;
	static int[][] xNy = {{-1,0},
						  {1, 0},
						  {0,-1},
						  {0,1}};
	
	static void dfs(int x, int y, boolean blind) {
		if( n > x && x >=0 && n > y && y >= 0) {
			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int newX = x+xNy[i][0];
				int newY = y+xNy[i][1];
				if( n > newX && newX >=0 && n > newY && newY >= 0) {
					
					char now = grids[x][y];
					if(blind) {
						if(now == 'B') {
							if(grids[newX][newY] == 'B' && visited[newX][newY] == false ) {
								dfs(newX,newY,blind);
							}
						}else {
							if(grids[newX][newY] != 'B' && visited[newX][newY] == false ) {
								dfs(newX,newY,blind);
							}
						}
						
					}else {
						if(now == grids[newX][newY] && visited[newX][newY] == false ) {
							dfs(newX,newY,blind);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		grids = new char[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			char[] grid = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				grids[i][j] = grid[j];
			}
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == false) {
					dfs(i,j,false);
					count++;
				}
			}
		}
		bw.write(count+" ");
		bw.flush();
		count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == false) {
					dfs(i,j,true);
					count++;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}
