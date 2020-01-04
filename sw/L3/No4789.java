package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No4789 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			int clapPeople = 0;
			int addedPeople = 0;
			int need = 0;
			//int[] peoples = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			char[] peoples = br.readLine().toCharArray();
			clapPeople+=peoples[0];
			for(int j = 1; j < peoples.length; j++) {
				if(clapPeople >= j) {
					clapPeople += (peoples[j]-'0');
				}else {
					need = j-clapPeople;
					addedPeople += need;
					clapPeople += need+(peoples[j]-'0');
				}
			}
			
			bw.write("#"+(i+1)+" "+addedPeople+"\n");
			bw.flush();
		}
	}
}
