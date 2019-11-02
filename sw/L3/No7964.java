package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;

public class No7964 {

	public static int isDoor(int nowIndex, int limitDistance, int[] mapInfo) {
		
		int count = 0;
		for (int i = nowIndex+1; i <= nowIndex+limitDistance; i++ ) {
			if( i == mapInfo.length) {
				return -1;
			}
			if (mapInfo[i] == 1){
				count++;
			}
		}
		if ( count > 0) {
			return nowIndex+count;
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException, ParseException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCaseNum; i++) {
		
			String[] strTestCase = br.readLine().split(" ");
			int cityNum = Integer.parseInt(strTestCase[0]);
			int limitDistance = Integer.parseInt(strTestCase[1]);
			String[] strMapInfo = br.readLine().split(" ");
			int[] mapInfo = Arrays.stream(strMapInfo).mapToInt(Integer::parseInt).toArray();
			
			System.out.print("#"+(i+1)+" ");
			int builtedDoor = 0;
			int j =0;
			while(true) {
				if( mapInfo[j] == 0 ) {
					int nextIndex = isDoor(j, limitDistance, mapInfo);
					
					//#2 testCase isDoor에 1이 있다면 처음에 관문이 있어야 서로 연결되는데, 그냥 넘어가는 문제 , #3같은 경우는 다 없기에 처음에 관문이 생김
					if ( nextIndex > 0 && j ==0) {
						mapInfo[j] = 1;
						builtedDoor++;
					}
					
					if (nextIndex == -1) break;
					
					if( nextIndex > 0) {
					
						j = nextIndex;
					}else {
						
						mapInfo[j] = 1;
						mapInfo[j+limitDistance] = 1;
						j+=limitDistance;
						
						builtedDoor = builtedDoor +2;
					}
					
				}else {
					
					int nextIndex = isDoor(j, limitDistance, mapInfo);
					
					if (nextIndex == -1) break;
					
					if( nextIndex > 0) {
						
						j = nextIndex;
					}else {
						
						mapInfo[j+limitDistance] = 1;
						j+=limitDistance;
						
						builtedDoor++;
					}
				}
			}
			
			System.out.println(builtedDoor);
		}
	}
}
