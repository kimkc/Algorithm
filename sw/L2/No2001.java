package L2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No2001 {

	/*
	public static int[] getFlapperIndex(int flapperSize) { //
		int[] flapperIndex = new int[flapperSize*flapperSize];
		int[] flapperValue = new int[flapperSize];
		for (int i = 0; i < flapperValue.length; i++) {
			flapperValue[i] = i;
		}
		for(int i = 0; i < flapperIndex.length; i++) {
			flapperIndex[i] = flapperValue[i%flapperSize];
		}
		return flapperIndex;
	}
	*/
	
	public static int sumFlapper(int[][] board, int boardX, int boardY, int flapperSize, int boardSize) {
		//int[] flapperIndex = getFlapperIndex(flapperSize); //
		int sum = 0;
		for(int i = 0; i < flapperSize; i++) {
			for(int j = 0; j < flapperSize; j++) {
				int x = j +boardX;
				int y = i +boardY;
				//System.out.println("#"+i+" boardX:"+boardX+" boardY:"+boardY+" x:"+x+" y:"+y);
				if (x >= boardSize || y >= boardSize) {
					return 0;
				}
				
				sum = sum + board[x][y];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); // 0.12219s
		//Scanner sc = new Scanner(System.in); //0.17523s
		int testCaseNum = Integer.parseInt(br.readLine());//sc.nextInt();
		
		for (int i = 0; i < testCaseNum; i++) {
			String[] boardNflapper = br.readLine().split(" ");//sc.nextInt();
			int boardSize = Integer.parseInt(boardNflapper[0]);
			int flapperSize = Integer.parseInt(boardNflapper[1]);//sc.nextInt();
			int[][] board = new int[boardSize][boardSize];
			for(int u = 0; u < boardSize; u++) {
				String[] board2int = br.readLine().split(" ");
				for(int p = 0; p < boardSize; p++) {
					board[u][p] = Integer.parseInt(board2int[p]);//sc.nextInt();
				}
			}
			
			//int[][] flapper = new int[flapperSize][flapperSize];
			
			System.out.print("#" + (i+1) + " ");
			ArrayList<Integer> sum = new ArrayList<Integer>();
			for(int j = 0; j < boardSize; j++) {
				for(int k = 0; k < boardSize; k++) {
					sum.add(sumFlapper(board, j, k, flapperSize, boardSize));
				}
			}
			System.out.println(Collections.max(sum));
			}
		}
}

