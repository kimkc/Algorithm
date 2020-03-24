package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No3260 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testCase; i ++) {
			String[] nums = br.readLine().split(" ");
			char[] num1 = nums[0].toCharArray();
			char[] num2 = nums[1].toCharArray();
			int index1 = num1.length-1;
			int index2 = num2.length-1;
			int[] result;
			
			if(num1.length > num2.length) {
				result = new int[num1.length+1];
			}else {
				result = new int[num2.length+1];	
			}
			int resultIndex = result.length-1;
			
			while( index1 > -1 && index2 > -1) {
				int temp = num1[index1]-'0'+num2[index2]-'0'+result[resultIndex];
				result[resultIndex] = temp % 10;
				result[resultIndex-1] = temp / 10;
				index1--;
				index2--;
				resultIndex--;
			}
			
			for(int j = index1; j > -1; j--) {
				int temp = result[resultIndex]+num1[j]-'0';
				result[resultIndex] = temp % 10;
				result[resultIndex-1] = temp / 10;
				resultIndex--;
			}
			
			for(int j = index2; j > -1; j--) {
				int temp = result[resultIndex]+num2[j]-'0';
				result[resultIndex] = temp % 10;
				result[resultIndex-1] = temp / 10;
				resultIndex--;
			}
			
			System.out.print("#"+i+" ");
			for(int j = 0; j < result.length; j++) {
				if(j == 0 && result[j] == 0) continue;
				System.out.print(result[j]);
			}
			System.out.println();
			
		}
		
	}
}
