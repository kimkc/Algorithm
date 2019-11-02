package L2;

import java.util.Scanner;

public class No1989 {

	public static int isPalindrome(String tc) {
		int tcLen = tc.length();
		String[] split = tc.split("");
		String reverseTC = "";
		for(int j=tcLen-1; j > -1; j--) {
			reverseTC= reverseTC+split[j];
		}
		return reverseTC.equals(tc)? 1:0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TCN = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<TCN; i++) {
			String testCase = sc.nextLine();
			System.out.print("#"+(i+1)+" ");
			System.out.print(isPalindrome(testCase));
			System.out.println();
		}
	}
}
