package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1987_dfs {
	static char[][] board;
	static boolean[][] visited;
	static int r,c;
	static int[] newY = {0, 1, 0, -1};
	static int[] newX = {1, 0, -1, 0};
	//A: 65 ~ Z: 90
	static boolean[] alph = new boolean[91];
	static int max = 0;
	
	static void dfs(int y, int x, int cnt) {
		visited[y][x] = true;
		alph[board[y][x]] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y+newY[i];
			int nx = x+newX[i];
			
			if(r > ny && ny > -1 && c > nx && nx > -1) {
				if( !alph[board[ny][nx]] && !visited[ny][nx]) {
					dfs(ny, nx, cnt+1);
					visited[ny][nx] = false;
					alph[board[ny][nx]] = false;
				}
			}
			
		}
		if(max < cnt) {
			max = cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rNc = br.readLine().split(" ");
		r = Integer.parseInt(rNc[0]);
		c = Integer.parseInt(rNc[1]);

		board = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String alphs = br.readLine();
			for(int j = 0; j < c; j++) {
				board[i][j] = alphs.charAt(j);
			}
		}
		
		dfs(0,0,1);
		System.out.println(max);
		
	}
}
