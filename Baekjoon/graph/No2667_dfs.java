package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class No2667_dfs {

	static char[][] maps;
	static int n;
	static int[][] xNy = {{-1,0},
			  {1, 0},
			  {0,-1},
			  {0,1}};

	static int dfs(int x, int y) {
		maps[x][y] = '0';
		int sum = 1;
		for(int i = 0; i < 4; i++) {
			int newX = x+xNy[i][0];
			int newY = y+xNy[i][1];
			if( n > newX && newX >=0 && n > newY && newY >= 0) {
				
				if( maps[newX][newY] == '1' ) {
					maps[newX][newY] = '0';
					sum += dfs(newX,newY);
				}	
			}
		}
		return sum;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		maps = new char[n][n];
		for(int i = 0; i < n; i++) {
			String map = br.readLine();
			for(int j = 0; j < n; j++) {
				maps[i][j] = map.charAt(j);
				}
		}
		int count = 0;
		ArrayList<Integer> houseNum = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(maps[i][j] == '1') {
					houseNum.add(dfs(i,j));
					count++;
				}
			}
		}
		bw.write(count+"\n");
		houseNum.sort(null);
		while(!houseNum.isEmpty()) {
			bw.write(houseNum.remove(0)+"\n");
		}
		bw.flush();
	}
}
