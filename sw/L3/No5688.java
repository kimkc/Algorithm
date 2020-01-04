package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No5688 {
	
	private static long[] memory = new long[1000001];
	
	public static int findIndex(int l,int r, long x) {
		if(l==r) {
			return -1; //
		}
		
		int memIndex =(int) Math.ceil((l+r)/2.0); //
		//System.out.println("l "+l+" r "+r+" index "+memIndex);
		int answer= 0;
				
		if(memory[memIndex]<x) {
          //  System.out.println(memory[memIndex]);
            if(l==memIndex){ //
            	return -1;
            }
			answer = findIndex(memIndex, r, x);
		}else if (memory[memIndex]>x) {
            if(r==memIndex){ //
            	return -1;
            }
           // System.out.println(memory[memIndex]);
			answer = findIndex(l,memIndex,x);
		}else {
			return memIndex;
		}
		return answer; //
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int j = 1; j < 1000001; j++ ) {
			memory[j]=(long)j*j*j; //
		}
        System.out.println(memory[1000000]);
		
		for(int i = 0; i < testNum; i++) {
			
			//max(x)= 1,000,000
			String strTestCase = br.readLine();
			long testCase = Long.parseLong(strTestCase);
			int answer = findIndex(0,1000000, testCase);
			
			
			wr.write("#"+(i+1)+" "+answer+"\n");
			wr.flush();
			}
		}

}


