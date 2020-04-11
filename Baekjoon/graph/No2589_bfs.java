package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class No2589_bfs {
	static char[][] map;
	static int row;
	static int col;
	static int[] newY = {0, 1, 0, -1};
	static int[] newX = {1, 0, -1, 0};
	static int max = 0;
	
	static void bfs(int y, int x, boolean[][] visited) {
		
		int[][] hours = new int[row][col];
		Queue<Loc> q = new LinkedList<Loc>();
		q.add(new Loc(y,x));
		int count = 0;//
		while(!q.isEmpty()) {
			count++;
			Loc loc = q.poll();
			visited[loc.y][loc.x] = true;
			
			for(int i = 0; i < 4; i ++) {
				int ny = loc.y+newY[i];
				int nx = loc.x+newX[i];
				
				if(ny >= 0 && row > ny && nx >= 0 && col > nx) {
					if(!visited[ny][nx] && map[ny][nx]=='L') {
						q.add(new Loc(ny,nx));
						hours[ny][nx] = hours[loc.y][loc.x] + 1;
						if(max < hours[ny][nx])
							max = hours[ny][nx];
					}
				}
			}
			
		}
		//
		System.out.println("count: "+count);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Runtime.getRuntime().gc();//
		
		String[] rowNcol = br.readLine().split(" ");
		row = Integer.parseInt(rowNcol[0]);
		col = Integer.parseInt(rowNcol[1]);
		
		map = new char[row][col];
		
		for(int i = 0; i < row; i++) {
			String lNw = br.readLine();
			for(int j = 0; j < col; j++) {
				map[i][j] = lNw.charAt(j);
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				boolean[][] visited = new boolean[row][col];
				if(map[i][j]=='L')
					bfs(i,j,visited);
			}
		}
		
		System.out.println(max);
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		System.out.println("used memory is " + used + " bytes");
	}
}

class Loc{
	int y;
	int x;
	Loc(int y, int x){
		this.y = y;
		this.x = x;
	}
}
