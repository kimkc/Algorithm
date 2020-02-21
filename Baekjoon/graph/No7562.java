package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No7562 {

	static int[][] yNx = {{-2,-1},{-2,1},{-1,-2},{-1,2},
						  {2,1}, {2, -1},{1,2},{1,-2}};
	static int n;
	static int[][] board;
	static int[] goal = new int[2];
	
	static int bfs(int y, int x) {
		if(y == goal[0] && x == goal[1]) {
			return 1;
		}
		Queue<Location> q = new LinkedList<Location>();
		q.add(new Location(y, x));
		board[y][x] = 1; // 0일 때 !visited인데, 이 명령이 없다면 다시 여기로 올 수도 있고 무한 반복 일어날 수 있음, 후에 거리 -1해주면 된다.
		while(!q.isEmpty()) {
			Location loc = q.remove();
			for(int i = 0; i < 8; i++) {
				int ny = loc.y + yNx[i][0];
				int nx = loc.x + yNx[i][1];
				if(ny == goal[0] && nx == goal[1]) {
					return board[loc.y][loc.x]+1;
				}
				
				if( n > ny && ny >= 0 && n > nx && nx >= 0 && board[ny][nx] == 0) {
					board[ny][nx] = board[loc.y][loc.x]+1;
					q.add(new Location(ny, nx));
				}
				
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		while(testCase > 0) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");
			goal[0] = Integer.parseInt(end[0]);
			goal[1] = Integer.parseInt(end[1]);
			System.out.println(bfs(Integer.parseInt(start[0]), Integer.parseInt(start[1]))-1);
			
			testCase--;
		}
	}
}

class Location{
	int y;
	int x;
	Location(int y, int x){
		this.y = y;
		this.x = x;
	}
}
