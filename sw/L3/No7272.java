package L3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7272 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {

			String[] testCase = br.readLine().split(" ");
			String[] str1 = testCase[0].split("");
			String[] str2 = testCase[1].split("");
			String regZero ="[^A|D|O|P|Q|R|B]";
			String regOne = "A|D|O|P|Q|R";
			String regTwo ="B";
			boolean isSame = false;
			
			System.out.print("#"+ (i+1) +" ");
			if(str1.length != str2.length) {
				System.out.println("DIFF");
			}else {
				for(int j = 0; j < str1.length; j++) {
					if(str1[j].matches(regTwo) == str2[j].matches(regTwo) && str1[j].matches(regOne) == str2[j].matches(regOne) && str1[j].matches(regZero) == str2[j].matches(regZero)) {
						isSame = true;
					}else {
						isSame = false;
						System.out.println("DIFF");
						break;
					}
				}
				if(isSame) System.out.println("SAME");
			}
			
		}
	}
}
