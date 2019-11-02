package L2;

import java.util.ArrayList;
import java.util.Scanner;

public class No2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tn = sc.nextInt();
		int[][] p = new int[10][];
		
		for (int i=0; i<tn; i++) {
			int n = sc.nextInt();
			System.out.println("#"+(i+1));
			for (int j=0; j<n; j++) {
				p[j]=new int[j+1];
			}
			p[0][0] = 1;
			for (int l=0; l < n; l++) {
				p[l][0] = p[l][l] =1;
			}
			
			for(int k=2; k <n; k++) {
				for (int y=1; y<k; y++) { //범위 위에서 처음과 끝은 1로 다 정해줌, index가 포함 안 되게
					p[k][y]=p[k-1][y-1]+p[k-1][y];
				}
			}
			
			for(int x=0; x<n; x++) {
				for(int z=0; z<x+1;z++) {
					System.out.print(p[x][z]);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	
	}	
}
