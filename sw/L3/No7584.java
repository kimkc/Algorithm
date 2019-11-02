package L3;

public class No7584 {

	public static String f(String str) {
		
	}
	
	public static void main(String[] args) {
		long pn = 3;
		for (int i = 2; ; i++) {
			if(pn > 5000000000000000L) {
				System.out.print(i);
				break;
			}
			pn = pn*2+1;
		}
		String firstStr = "001001100011011";
		for( int j = 0; j < 20; j++) {
			firstStr= firstStr+"0";
			for(int k = firstStr.length()-1; k >= 0; k--) {
				char temp = firstStr.charAt(k) == 1 ? '0':'1';
				firstStr+= temp;
			}
		}
		System.out.println(firstStr);
	}
}
