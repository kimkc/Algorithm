package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//주석처리된 temp는 왜 없어도 되는가? 설명하시오
public class No14502_dfs {

	static int n;
	static int m;
	static int max;
	static int[][] labs;
//	static int[][] temp;
	static int[][] xNy = {{-1,0},
			  {1, 0},
			  {0,-1},
			  {0,1}};
	
	public static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++) {
			int newX = x+xNy[i][0];
			int newY = y+xNy[i][1];
			if( n > newX && newX >=0 && m > newY && newY >= 0) {
				
				if( labs[newX][newY] == 0 ) {
					labs[newX][newY] = 2;
					dfs(newX,newY);
				}	
			}
		}
	}
	
	public static void makeWall(int wallNum) {
		if(wallNum == 3) {
			int[][] afterSpread = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					afterSpread[i][j] = labs[i][j];
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(labs[i][j] == 2)
						dfs(i,j);
				}
			}
			
			int result = countZero();
			if(max < result) {
				max = result;
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					labs[i][j] = afterSpread[i][j];
				}
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(labs[i][j] == 0) {
					labs[i][j] = 1;
					makeWall(wallNum+1);
					labs[i][j] = 0;
				}
			}
		}
		
	}
	
	public static int countZero() {
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(labs[i][j] == 0)
					count++;
			}
		}
		return count;
	}
/*
	public static void storeNback(boolean isStore) {
		if(isStore) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					temp[i][j] = labs[i][j];
				}	
			}	
		}else {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					labs[i][j] = temp[i][j];
				}
			}
		}
	}
*/
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String nNm = br.readLine();
		n = nNm.charAt(0) - '0';
		m = nNm.charAt(2) - '0';
		
		labs = new int[n][m];
//		temp = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String lab = br.readLine();
			for(int j = 0; j < m; j++) {
				labs[i][j] = lab.charAt(j*2) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(labs[i][j] == 0) {
					labs[i][j] = 1;
					makeWall(1);
					labs[i][j] = 0;
				}
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		
	}
}
