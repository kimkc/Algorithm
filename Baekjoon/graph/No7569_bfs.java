package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569_bfs {
	static int n;
	static int m;
	static int h;
	static int[][] newyxz = {
			  {-1,0,0},
			  {1,0,0},
			  {0,-1,0},
			  {0,1,0},
			  {0,0,-1},
			  {0,0,1}};
	static int[][][] boxes;
	
	public static int bfs() {
		int day = -1;
		
		Queue<Area> q = new LinkedList<Area>();
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(boxes[k][i][j] == 1) {
						q.add(new Area(i,j,k));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				Area area = q.poll();
				
				for(int z = 0; z < 6; z++) {
					int ny = area.y + newyxz[z][0];
					int nx = area.x + newyxz[z][1];
					int nz  = area.z + newyxz[z][2];
					if( m > ny && ny >=0 && n > nx && nx >= 0 && h > nz && nz >= 0) {
						if(boxes[nz][ny][nx] == 0) {
							boxes[nz][ny][nx] = 1;
							q.add(new Area(ny,nx,nz));
						}
					}
				}
				size--;
			}
			day++;
		}
		
		return day;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int ripeCount = 0;
		int day = 0;
		boxes = new int[h][m][n];
		
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					boxes[k][i][j] = Integer.parseInt(st.nextToken());
					if(boxes[k][i][j] !=0)
						ripeCount++;
				}
			}
		}
		
		if(ripeCount == n*m*h) {
			System.out.println('0');
		}else {
			boolean isRipe = true;
			day = bfs();
			for(int k = 0; k < h; k++) {
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < n; j++) {
						if(boxes[k][i][j] == 0) {
							isRipe = false;
							break;
						}
					}
				}
			}
			if(isRipe)
				System.out.println(day);
			else
				System.out.println("-1");
		}
	}
}

class Area{
	int y;
	int x;
	int z;
	
	Area(int y, int x, int z){
		this.y = y;
		this.x = x;
		this.z = z;
	}
	
}
	/*
	static int n;
	static int m;
	static int h;
	static int[][] newyxz = {
			  {-1,0,0},
			  {1,0,0},
			  {0,-1,0},
			  {0,1,0},
			  {0,0,-1},
			  {0,0,1}};
	static int[][][] boxes;
	
	public static int bfs() {
		int day = 0;
		
		ArrayList<Area> q = new ArrayList<Area>();
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(boxes[k][i][j] == 1) {
						q.add(new Area(i,j,k));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			day++;
			while(size > 0) {
				Area area = q.remove(q.size()-1);
				
				for(int z = 0; z < 6; z++) {
					int ny = area.y + newyxz[z][0];
					int nx = area.x + newyxz[z][1];
					int nz  = area.z + newyxz[z][2];
					if( m > ny && ny >=0 && n > nx && nx >= 0 && h > nz && nz >= 0) {
						if(boxes[nz][ny][nx] == 0 || boxes[nz][ny][nx] == 1) {
							boxes[nz][ny][nx] = 1;
							q.add(new Area(ny,nx,nz));
						}
					}
				}
				//
				for(int k = 0; k < h; k++) {
					for(int i = 0; i < m; i++) {
						for(int j = 0; j < n; j++) {
							System.out.print(boxes[k][i][j]+" ");
						}
						System.out.println();
					}
				}
				System.out.println("------------------");
				//
				size--;
			}
			System.out.println("-------"+day+"-----------");
			
		}
		
		return day;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int ripeCount = 0;
		int day = 0;
		boxes = new int[h][m][n];
		
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					boxes[k][i][j] = Integer.parseInt(st.nextToken());
					if(boxes[k][i][j] !=0)
						ripeCount++;
				}
			}
		}
		
		if(ripeCount == n*m*h) {
			System.out.println('0');
		}else {
			boolean isRipe = true;
			day = bfs();
			for(int k = 0; k < h; k++) {
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < n; j++) {
						if(boxes[k][i][j] == 0) {
							isRipe = false;
							break;
						}
					}
				}
			}
			if(isRipe)
				System.out.println(day);
			else
				System.out.println("-1");
		}
	}
}

class Area{
	int y;
	int x;
	int z;
	
	Area(int y, int x, int z){
		this.y = y;
		this.x = x;
		this.z = z;
	}
	
}
	------------------------
	static int n;
	static int m;
	static int[][] newyx = {
			  {-1,0,0},
			  {1,0,0},
			  {0,-1,0},
			  {0,1,0}};
	static int[][][] boxes;
	
	public static int bfs(int maxOne) {
		int day = 0;
		
		ArrayList<Area> q = new ArrayList<Area>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(boxes[maxOne][i][j] == 1) {
					q.add(new Area(i,j));
				}
			}
		}
		int forDay = q.size();
		
		while(!q.isEmpty()) {
			Area area = q.remove(q.size());
			queueCount--;
			if(queueCount == 0) {
				
			}
			int qinsert = 0;
			for(int z = 0; z < 4; z++) {
				int ny = area.y + newyxz[z][0];
				int nx = area.x + newyxz[z][1];
				if( m > ny && ny >=0 && n > nx && nx >= 0) {
					q.add(new Area(ny,nx));
					qinsert++;
					boxes[maxOne][ny][nx] = 1;
				}
			}
		}
		
		return day;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int ripeCount = 0;
		int maxRipeIndex = 0;
		int maxRipeCount = 0;
		int day = 0;
		boxes = new int[h][m][n];
		
		for(int k = 0; k < h; k++) {
			int oneCount = 0;
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					boxes[k][i][j] = Integer.parseInt(st.nextToken());
					if(boxes[k][i][j] !=0)
						ripeCount++;
					else if(boxes[k][i][j] == 1)
						oneCount++;
				}
			}
			if(maxRipeCount < oneCount) {
				maxRipeCount = oneCount;
				maxRipeIndex = k;
			}
		}
		
		if(ripeCount == n*m*h) {
			System.out.println('0');
		}else {
			day = bfs(maxRipeIndex);
		}
	}
}

class Area{
	int y;
	int x;
	
	Area(int y, int x){
		this.y = y;
		this.x = x;
	}
	
}
*/