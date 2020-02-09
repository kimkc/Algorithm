package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3809 {
/*
 * 	public static void main(String args[]) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testCase; i++) {
			boolean[] isExist = new boolean[1001];
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			if(n < 20) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					nums[j] = Integer.parseInt(st.nextToken());
					isExist[nums[j]] = true;
				}
			}else { 
				for(int j = 0; j < (n/20)-1; j++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for(int k = 20*j; k < 20*(j+1); k++) {
						nums[k] = Integer.parseInt(st.nextToken());
						isExist[nums[k]] = true;
					}
				}
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = ((n/20)-1)*20; k < n; k++) {
					nums[k] = Integer.parseInt(st.nextToken());
					isExist[nums[k]] = true;
				}
			}
			
			//for(int j = 2; j < 4; j++) { 어떻게 이용해서 하드 코딩 안 하지..
			for(int k = 0; k < n-1; k++) {
				int sum = nums[k]*10+nums[k+1];
				isExist[sum] = true;
			}
			//}
			boolean go = true;
			
			for(int j = 0; j < 100; j++) {
				if(!isExist[j]) {
					go = false;
					System.out.println("#"+i+" "+j);
					break;
				}	
			}
			if(go) {
				for(int k = 0; k < n-2; k++) {
					int sum = nums[k]*100+nums[k+1]*10+nums[k+2];
					isExist[sum] = true;
				}
				for(int j = 100; j < 1000; j++) {
					if(!isExist[j]) {
						System.out.println("#"+i+" "+j);
						break;
					}
				}
			}
		}
	}
	*/
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 1; i <= testCase; i++) {
			boolean[] isExist = new boolean[1001];
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			if(n < 20) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					//nums[j] = Integer.parseInt(st.nextToken());
					isExist[nums[j]] = true;
				}
			}else {
                int endIndex;
                if(n%20 != 0) 
                    endIndex = n/20; // 99-> 4
                else
                	endIndex = n/20-1; // 100 -> 4
                System.out.println("endIndex: "+endIndex);
				for(int j = 0; j < endIndex; j++) {
					System.out.println(20*j+" "+20*(j+1));//
					//StringTokenizer st = new StringTokenizer(br.readLine());
					for(int k = 20*j; k < 20*(j+1); k++) {
						//nums[k] = Integer.parseInt(st.nextToken());
						isExist[nums[k]] = true;
					}
				}
				//StringTokenizer st = new StringTokenizer(br.readLine());
                System.out.println(endIndex*20+" "+n);
				for(int k = endIndex*20; k < n; k++) {
					//nums[k] = Integer.parseInt(st.nextToken());
					isExist[nums[k]] = true;
				}
			}
			
			for(int k = 0; k < n-1; k++) {
				int sum = nums[k]*10+nums[k+1];
				isExist[sum] = true;
			}

            boolean go = true;
			
			for(int j = 0; j < 100; j++) {
				if(!isExist[j]) {
					go = false;
					System.out.println("#"+i+" "+j);
					break;
				}	
			}
			if(go) {
				for(int k = 0; k < n-2; k++) {
					int sum = nums[k]*100+nums[k+1]*10+nums[k+2];
					isExist[sum] = true;
				}
				for(int j = 100; j < 1001; j++) {
					if(!isExist[j]) {
						System.out.println("#"+i+" "+j);
						break;
					}
				}
			}
		}
	}
}
