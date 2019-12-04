package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No6057 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			String[] testCase = br.readLine().split(" ");
			int triangleNum =0;
			int N = Integer.parseInt(testCase[0]);
			int[][] matrix = new int[N][N];
			int M = Integer.parseInt(testCase[1]);
			
			for(int j = 0; j < M; j++) {
				String[] twoPoint = br.readLine().split(" ");
				int x = Integer.parseInt(twoPoint[0])-1;
				int y = Integer.parseInt(twoPoint[1])-1;
				matrix[x][y]=1;
				matrix[y][x]=1;
			}
			
			//무방향이기에 중복 없이 하기 위해
			for(int a = 0; a < N-1; a++) {
				for(int b = a+1; b < N-1; b++) {
					 if(matrix[a][b]>0 || matrix[a][b+1]>0){
							for (int c = b+1; c < N; c++) {
								if(matrix[a][b]==1 && matrix[a][c]==1 && matrix[b][c]==1) {
									triangleNum++;
								}
							}
	                    }
					}
				}
			
			wr.write("#"+(i+1)+" "+triangleNum+"\n");
			wr.flush();
			}
		}
}
