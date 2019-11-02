package L2;

import java.util.ArrayList;
import java.util.Scanner;

public class No2007 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aList = new ArrayList<String>();
		int tc = scan.nextInt();
		scan.nextLine(); // nextInt()에서 사용한 \n 빼고 가져감, 그래서 \n이 그 다음 scan까지 넘어감, nextLine()은 \n을 같이 가져감 nextInt 다음 nextLine사용시 \n신경쓰기
		
		for (int i = 0; i < tc; i++) {
			String tcase = scan.nextLine();
			aList.add(tcase);
			}
		
		for (int i = 0; i < tc; i++) {
			String TestCase = aList.get(i);
			String subStr1 = "";
			String subStr2 = " ";
			int plusSubStr = 1;
			//equals VS ==, all is object in java
			while (!subStr1.equals(subStr2)) {
				subStr1 = TestCase.substring(0, plusSubStr);
				subStr2 = TestCase.substring(plusSubStr,plusSubStr+subStr1.length());
				plusSubStr++;
			}
			System.out.println("#" + (i+1) + " " + subStr1.length());
				
		}
		scan.close();
	}
}
