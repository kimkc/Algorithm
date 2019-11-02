package L3;

import java.util.Scanner;

public class No8104 {

	public static int makeCell(int[][] cell, int k, int student, int nInK) {
		if (nInK % 2 ==0) {
			for(int i = 0; i<k; i++) {
				cell[i][nInK] = student;
				student++;
			}
		}else{
			for(int j = k-1; j > -1; j--) {
				cell[j][nInK] = student;
				student++;
			}
		}
		return student;
	}
	
	public static void printSum(int[][] cell, int k, int n) {
		for (int i = 0; i < k; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum= sum + cell[i][j];
			}
			System.out.print(sum);
			System.out.print(" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int i = 0; i < testCase; i++ ) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int student = 1;
			int[][] cell = new int[k][n];
			
			for (int j = 0; j < n; j++) {
				student=makeCell(cell, k, student, j);
			}
			System.out.print("#"+(i+1)+" ");
			printSum(cell, k, n);
			System.out.println();
		}
		sc.close();
	}
}
