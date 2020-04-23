package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2145_bfs {
	static int[][] maps;
	static boolean[][] visited;
	static int min = 10000;
	static int n;
	
	static int islandCount = 1;
	static int[] newY = {0, 0, 1, -1};
	static int[] newX = {-1, 1, 0, 0};
	
	public static void dfs(int y, int x, int islandCount) {
		visited[y][x] = true;
		maps[y][x] = islandCount;
		
		
		for(int i = 0; i < 4; i++) {
			int ny = y+newY[i];
			int nx = x+newX[i];
			
			if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
				if(!visited[ny][nx] && maps[ny][nx] != 0 ) {
					dfs(ny, nx, islandCount);
				}
			}
		}
	}
	
	public static void bfs(int y, int x, int nowIsland) {
		boolean[][] visitedSea = new boolean[n][n];
		Queue<Loc> q = new LinkedList<Loc>();
		
		visitedSea[y][x] = true;
		q.add(new Loc(y,x));
		
		int distance = 0;
		boolean isMin = false;
		
		while(!q.isEmpty()) {
			int qLen = q.size();
			while(qLen-- > 0) {
				Loc loc = q.poll();
				for(int i = 0; i < 4; i++) {
					int ny = loc.y+newY[i];
					int nx = loc.x+newX[i];
				
					if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
						//System.out.println(ny+" "+ nx);
						if(maps[ny][nx] != 0 && maps[ny][nx] != nowIsland ) { 
							isMin = true;
							break;
						}
						if(!visitedSea[ny][nx] && maps[ny][nx] == 0 ) {
							visitedSea[ny][nx] = true;
							q.add(new Loc(ny, nx));
						}
					}
				}
				if(isMin) break;
			}
			distance++;
			if(isMin) break;
		}
		if(min > distance && distance != 1) {
			min = distance;
			visitedSea = new boolean[n][n];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		maps = new int[n][n];
		
		visited= new boolean[n][n]; 
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && maps[i][j] != 0) {
					dfs(i,j,islandCount);
					islandCount++;
				}
			}
		}
		/*
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
		*/
		//각 섬 당 끝 구간에서 bfs를 다 돌려줘야 알 수 있다. 만약 100x100일 때, 1칸씩 띄고 섬이 있다면 5000개가 있는데 5000개 중 하나가 도는데 5000번인데, 5000*5000번=25,000,000이다. 2초안에 가능
		//어려운 구간: 한 섬의 모든 끝 부분마다 bfs를 실행하며 최단 거리를 구하는데, 이때, 모든 정점을 다 고려하는 것이 아니라 다른 섬까지가는 길이만 구해야하는데 잘모르겠음 -> bfs가 어떤 섬에서 호출된지 저장하고, 0일 때 계속 시도하고, 현재 섬이 아닌 섬을 만났을 때가 최소니까 그때까지의 길이만 구하면 된다. 꼭 다 돌 필요 없음.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(maps[i][j] != 0) {
					bfs(i, j, maps[i][j]);
				}
			}
		}
		
		System.out.println(min-1); //테스트 케이스 더 고려해야함!!!
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
