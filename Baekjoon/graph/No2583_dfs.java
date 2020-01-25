package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2583_dfs {
	static int[][] boards;
	static int count = 0;
	static int[] areas = new int[80];
	static int m;
	static int n;
	static int[][] xNy = {{-1,0},
			  {1, 0},
			  {0,-1},
			  {0,1}};
	
	public static void dfs(int x, int y, int count) {
		boards[x][y] = 1;
		areas[count]++;
		for(int i = 0; i < 4; i++) {
			int newX = x+xNy[i][0];
			int newY = y+xNy[i][1];
			if( m > newX && newX >=0 && n > newY && newY >= 0) {
				
				if( boards[newX][newY] == 0 ) {
					//boards[newX][newY] = 1;
					dfs(newX,newY, count);
				}	
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] mNnNk = br.readLine().split(" ");
		m = Integer.parseInt(mNnNk[0]);
		n = Integer.parseInt(mNnNk[1]);
		int k = Integer.parseInt(mNnNk[2]);
		boards = new int[m][n];
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			/*String[] leftRight = br.readLine().split(" ");
			int leftY = Integer.parseInt(leftRight[0]);
			int leftX = Integer.parseInt(leftRight[1]);
			int rightY = Integer.parseInt(leftRight[2]);
			int rightX = Integer.parseInt(leftRight[3]);
			*/
			int leftY = Integer.parseInt(st.nextToken());
			int leftX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken()); 
			
			for(int x = leftX; x < rightX; x++) {
				for(int y = leftY; y < rightY; y++) {
					boards[x][y] = 1;
				}
			}
		}
		/*
		for(int x = 0; x < m; x++) {
			for(int y = 0; y < n; y++) {
				System.out.print(boards[x][y]);
			}
			System.out.println();
		}
		*/
		for(int x = 0; x < m; x++) {
			for(int y = 0; y < n; y++) {
				if(boards[x][y] == 0) {
					dfs(x,y,count);
					count++;
				}
			}
		}
			
		bw.write(count+"\n");
		Arrays.sort(areas);
		for(int j = 80-count; j < 80; j++) {
			bw.write(areas[j]+" ");
		}
		bw.flush();
	}
}
/*
 *import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int[][] boards;
	static int count = 0;
	static int m;
	static int n;
	static int[][] xNy = {{-1,0},
			  {1, 0},
			  {0,-1},
			  {0,1}};
	static int area = 0;
    
	public static void dfs(int x, int y, int count) {
		boards[x][y] = 1;
        area++;
        for(int i = 0; i < 4; i++) {
			int newX = x+xNy[i][0];
			int newY = y+xNy[i][1];
			if( m > newX && newX >=0 && n > newY && newY >= 0) {
				
				if( boards[newX][newY] == 0 ) {
					//boards[newX][newY] = 1;
					dfs(newX,newY, count);
				}	
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] mNnNk = br.readLine().split(" ");
		m = Integer.parseInt(mNnNk[0]);
		n = Integer.parseInt(mNnNk[1]);
		int k = Integer.parseInt(mNnNk[2]);
		boards = new int[m][n];
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int leftY = Integer.parseInt(st.nextToken());
			int leftX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken()); 
			
			for(int x = leftX; x < rightX; x++) {
				for(int y = leftY; y < rightY; y++) {
					boards[x][y] = 1;
				}
			}
		}
		//
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
       
		for(int x = 0; x < m; x++) {
			for(int y = 0; y < n; y++) {
                //
                area = 0;
				if(boards[x][y] == 0) {
					dfs(x,y,count);
					count++;
                    //
                    pq.offer(area);
				}
			}
		}
			
		bw.write(count+"\n");
        //
		while(!pq.isEmpty())
            bw.write(pq.poll() + " ");
        //
		bw.flush();
	}
}


 */

