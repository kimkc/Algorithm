package L3;

public class No3131 {
	public static void main(String[] args){
	
		boolean[] decimal = new boolean[1000001];
		decimal[0] = true;
		decimal[1] = true;
		for(int i = 2; i <= 1000; i++) {
			for(int j = i+i; j <= 1000000; j+=i) {
				decimal[j] = true;
			}
		}
		
		for(int i = 2; i <= 1000000; i++) {
			if(decimal[i] == false) 
				System.out.print(i+" ");
		}
	}
}
