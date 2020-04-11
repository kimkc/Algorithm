package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class No11559_dfs {

	static char[][] board = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] newY = {0, 1, 0, -1};
	static int[] newX = {1, 0, -1, 0};
	
	static int dfs(int y, int x, int cnt) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y+newY[i];
			int nx = x+newX[i];
			
			if(12 > ny && ny > -1 && 6 > nx && nx > -1) {
				if(board[y][x] == board[ny][nx] && !visited[ny][nx]) {
					int chain  = dfs(ny, nx, cnt+1);
					System.out.println(board[ny][nx]+" chain: "+ chain);
					System.out.println(ny+" "+nx);
					
					if(chain > 3) {
						//board[y][x] = '.'; // for�� ���� �� '.'���� �ٲ��, '.'�� �Ͱ� ���� �͵� ���ԵǾ� ����ȴ�.
						board[ny][nx] = '.';
						return chain;
					}
				}
			}
			
		}
		
		return cnt;
		
	}

	static void arrange() {
		for(int i = 0; i < 6; i++) {
			int j = 11;
			while(j > -1) {
				int dotCnt = 0;
				int y = j;
				while(y > -1 && board[y][i] == '.') {
					dotCnt++;
					y--;
				}
				
				if(dotCnt > 0) {
					while(y+dotCnt < 12 && y > -1 && board[y][i] != '.') {
						board[y+dotCnt][i] = board[y][i];
						board[y][i] = '.';
						y--;
					}
					j = y;
				}else {
					j--;
				}
				
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 0;
		
		for(int i = 0; i < 12; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 6; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
	//	
	int l = 6;
	while(l-- > 0) {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(board[i][j] != '.') {
					if(dfs(i, j, 1) > 3) {
						//�ѹ� dfs 4�̻� �������� ��
						board[i][j] = '.';
						arrange();
						c++;
						for(int y = 0; y < 12; y++) {
							for(int x = 0; x < 6; x++) {
								visited[y][x] = false;
							}
						}
	
					}
				}
			}
			
 		}
		
	}
		
		//
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
 		}
		
		System.out.println();
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
 		}
		
		
		System.out.println(dfs(10,3,1));
		System.out.println(c);
		//
	}
}

/*
public class No11559_dfs {

	static char[][] board = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] newY = {0, 1, 0, -1};
	static int[] newX = {1, 0, -1, 0};
	
	/
		�� ���°�  �̻��ϰ� dfs�� �����Ѵ�. ������ �𸣰ڴ�. cnt�� 4�� ���� �ʴ´�.
	......
	...G..
	..GGG.
	/
	static int dfs(int y, int x, int cnt) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y+newY[i];
			int nx = x+newX[i];
			
			if(12 > ny && ny > -1 && 6 > nx && nx > -1) {
				if(board[y][x] == board[ny][nx] && !visited[ny][nx]) {
					int chain  = dfs(ny, nx, cnt+1);
					System.out.println(board[ny][nx]+" chain: "+ chain);
					System.out.println(ny+" "+nx);
					
					if(chain > 3) {
						//board[y][x] = '.'; // for�� ���� �� '.'���� �ٲ��, '.'�� �Ͱ� ���� �͵� ���ԵǾ� ����ȴ�.
						board[ny][nx] = '.';
						return chain;
					}else {
						//visited[y][x] = false;
						visited[ny][nx] = false;
					}
				
				}
			}
			
		}
		
		return cnt;
		
	}

	static void arrange() {
		for(int i = 0; i < 6; i++) {
			int j = 11;
			while(j > -1) {
				int dotCnt = 0;
				int y = j;
				while(y > -1 && board[y][i] == '.') {
					dotCnt++;
					y--;
				}
				
				if(dotCnt > 0) {
					while(y+dotCnt < 12 && y > -1 && board[y][i] != '.') {
						board[y+dotCnt][i] = board[y][i];
						board[y][i] = '.';
						y--;
					}
					j = y;
				}else {
					j--;
				}
				
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 0;
		
		for(int i = 0; i < 12; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 6; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(board[i][j] != '.') {
					if(dfs(i, j, 1) > 3) {
						//�ѹ� dfs 4�̻� �������� ��
						board[i][j] = '.';
						for(int y = 0; y < 12; y++) {
							for(int x = 0; x < 6; x++) {
								visited[y][x] = false;
							}
						}
						//������ �� �߷����� ���� ���� ����
						arrange();
						c++;
						
					}else {
						visited[i][j] = false;
						
					}
				}
			}
			
 		}
		
		
		
		//
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
 		}
		
		System.out.println();
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
 		}
		
		
		System.out.println(dfs(3,2,1));
		System.out.println(c);
		//
	}
}
*/