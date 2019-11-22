package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class No8500 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter( new OutputStreamWriter(System.out));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			int num = Integer.parseInt(br.readLine());
			 //int[] emptySeats = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//위보다 밑의 과정이 더 빠름 큰 차이는 없음
			String[] temp = br.readLine().split(" ");
			int[] emptySeats = new int[temp.length];
			for(int j = 0; j < num; j++) {
				emptySeats[j] = Integer.parseInt(temp[j]);
			}
			Integer[] emptySeat = Arrays.stream(emptySeats).boxed().toArray(Integer[]::new); 
			Arrays.sort(emptySeat, Comparator.reverseOrder());
			
			int sum=0;
			
			sum += emptySeat[0]*2+1;

			for(int j = 1; j < num; j++) {
				sum += emptySeat[j]+1;
			}
			/*
			ArrayList<Integer> seats = new ArrayList<Integer>();
			for(int x = 0;  x < emptySeat[0]; x++) {
				seats.add(0);
			}
			seats.add(1);
			for(int x = 0;  x < emptySeat[0]; x++) {
				seats.add(0);
			}
			//11+3+(1+4)+2+(3+5)
			for(int k = 1; k < num; k++) {
				if(emptySeat[k-1] >= emptySeat[k]) {
					seats.add(1);
					for(int y = 0; y < emptySeat[k]; y++) {
						seats.add(0);
					}
				}else {//역순으로 정렬하기에 비교할 필요없은 전의 값이 무조건 더 크다.
					for(int w = 0; w < emptySeat[k]-emptySeat[k-1]; w++) {
						seats.add(0);
					}
					seats.add(1);
					for(int s = 0; s < emptySeat[k]; s++) {
						seats.add(0);
					}
				}
				
			}
			*/
			wr.write("#"+(i+1)+" "+sum+"\n");
			wr.flush();
		}
	}
}
