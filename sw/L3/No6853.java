package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No6853 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			int[] vertexes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] counts = new int[3];
			
			int N = Integer.parseInt(br.readLine());
			int[] dots = new int[N*2];
			
			for (int j = 0; j < N*2; j=j+2) {
				int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				dots[j]=temp[0];
				dots[j+1]=temp[1];
			}
			
			for(int k = 0; k < N*2; k+=2) {
				int x = dots[k];
				int y = dots[k+1];
				
				/*
				if( ((x == vertexes[0] || x==vertexes[2]) && (y>= vertexes[0] && y<= vertexes[2])) || ((y == vertexes[0] || y==vertexes[2]) && (x>= vertexes[0] && x<= vertexes[2]))) {
					counts[1]++;
				}else if( (x>= vertexes[0] && x<=vertexes[2]) && (y>= vertexes[0] && y<= vertexes[2]) ) {
					counts[0]++;
				}else {
					counts[2]++;
				}*/
				
				if( ((x == vertexes[0] || x==vertexes[2]) && (y>= vertexes[1] && y<= vertexes[3])) || ((y == vertexes[1] || y==vertexes[3]) && (x>= vertexes[0] && x<= vertexes[2]))) {
					counts[1]++;
				}else if( (x>= vertexes[0] && x<=vertexes[2]) && (y>= vertexes[1] && y<= vertexes[3]) ) {
					counts[0]++;
				}else {
					counts[2]++;
				}
				
			}
			
			System.out.println("#"+(i+1)+" "+counts[0]+ " " + counts[1]+" "+counts[2]);
		}
	}
}
