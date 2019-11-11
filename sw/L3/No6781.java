package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No6781 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNum; i++) {
			int[] redCount = new int[9];
			int[] greenCount = new int[9];
			int[] blueCount = new int[9];
			
			int[] nums = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			String[] colors = br.readLine().split("");
			int setCount=0;
			
			for(int j = 0; j < 9; j++) {
				if (colors[j].equals("R")) {
					redCount[nums[j]-1]++;
				}else if (colors[j].equals("G")) {
					greenCount[nums[j]-1]++;
				}else {
					blueCount[nums[j]-1]++;
				}
			}
			
			/*
			 * 5
			123345777
			RRRRRRGGG
			122344445
			RRRRRRRRR
			123444555
			RRBRRRRRR
			111345666
			RRBGGGRRR
			222333111
			RGBRGBRGB
			123123345 
			RRRRRRRRR
			123234345
			RRRRRRRRR
			111223344  win�̾ƴ� continue ��
			RRRRRRRRR
			
			�������ذ��� ���� ���ǹ���, 123,123�� ���� ������ Ȯ�����ְ�, 3���� ���� �����ִ��� Ȯ����
			*******�̰� �� �� ����ε� 3���� ��Ʈ�� ��������� �Ǵ����� ���� �����غ���, ���ڽż����غ���,�޸𸮽ð� �ξ� ���� �� ���� ����غ���****
			*�������� �ذ�Ǵ� �˰��� �����غ���, 3�������ϸ� �ذ��� ��
			 */
			
				for(int x = 0; x < 7; x++) {
					for( int z =0; z <2; z++){	
                    int redSeqNum = 0;
                    if( redCount[x] >0 && redCount[x+1] > 0 && redCount[x+2] >0){
						redSeqNum = redCount[x]+redCount[x+1]+redCount[x+2];
						if (redSeqNum >= 3) {
							setCount++;
							redCount[x]--;
							redCount[x+1]--;
							redCount[x+2]--;
						}
                    }
				
					int greenSeqNum = 0;
                    if( greenCount[x] >0 && greenCount[x+1] > 0 && greenCount[x+2] >0){
						greenSeqNum = greenCount[x]+greenCount[x+1]+greenCount[x+2];
						if (greenSeqNum >= 3) {
							setCount++;
							greenCount[x]--;
							greenCount[x+1]--;
							greenCount[x+2]--;
						}
                    }
				
					int blueSeqNum = 0;
                     if( blueCount[x] >0 && blueCount[x+1] > 0 && blueCount[x+2] >0){
					
						blueSeqNum = blueCount[x]+blueCount[x+1]+blueCount[x+2];
						if (blueSeqNum >= 3) {
							setCount++;
							blueCount[x]--;
							blueCount[x+1]--;
							blueCount[x+2]--;
						}
					}
                    }
                }
			
			for(int k = 0; k < 9; k++) {
				if (redCount[k] >= 3) {
					setCount++;
					redCount[k] =redCount[k] % 3;
				}
				if (greenCount[k] >= 3) {
					setCount++;
					greenCount[k]=greenCount[k] % 3;
				}
				if (blueCount[k] >= 3) {
					setCount++;
					blueCount[k]=redCount[k] % 3;
				}
			}
			
			
			if( setCount == 3) {
				System.out.println("#"+(i+1)+" "+"Win");
			}else {
				System.out.println("#"+(i+1)+" "+"Continue");
			}
		}
	}
}

