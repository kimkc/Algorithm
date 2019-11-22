package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class No6900 {

public static boolean isWin(String winNum, String lottoNum) {
	for(int i = 0; i < winNum.length(); i +=2) {
		if(lottoNum.charAt(winNum.charAt(i)-48) != winNum.charAt(i+1)) {
			return false;
		}
	}
	return true;
}

public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testNum; i++) {
			
			String[] winNnum = br.readLine().split(" ");
			int win = Integer.parseInt(winNnum[0]);
			int num = Integer.parseInt(winNnum[1]);
			ArrayList<String> winNmoney = new ArrayList<String>();
			ArrayList<String> lottoNums = new ArrayList<String>();
			int sum = 0;
			
			for(int j = 0 ; j < win; j++) {
				String[] winMoney = br.readLine().split(" ");
				String indexNnum = "";
				for(int z = 0; z < 8; z++) {
					if(winMoney[0].charAt(z) !='*') {
						indexNnum += z;
						indexNnum += winMoney[0].charAt(z);
					}
				}
				winNmoney.add(indexNnum);
				winNmoney.add(winMoney[1]);
			}
			
			for(int k = 0; k < num; k++) {
				lottoNums.add(br.readLine());
			}
			
			for(int x=0; x < winNmoney.size(); x +=2) {
				String winNum = winNmoney.get(x);
				int winnings = Integer.parseInt(winNmoney.get(x+1));
				
				for(int y = 0; y < lottoNums.size(); y++) {
					String lottoNum = lottoNums.get(y);
					
					if(isWin(winNum,lottoNum)) {
						sum += winnings;
					}
				}
			}
			
			System.out.println("#"+(i+1)+" "+sum);
		}
	}
}
