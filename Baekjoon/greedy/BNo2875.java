package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BNo2875 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[] nmk = br.readLine().split(" ");
		
		int women = Integer.parseInt(nmk[0]);
		int men = Integer.parseInt(nmk[1]);
		int intern = Integer.parseInt(nmk[2]);
		
		int maxTeam = 0;
		int leftWomen, leftMen;
		for(int i = 0; i <= intern; i++) {
			leftWomen = women - (intern - i);
			leftMen = men - i;
			
			if(leftWomen > 1 && leftMen > 0) {
				int womenTeam = leftWomen/2;
				if(womenTeam >= leftMen && leftMen > maxTeam) {
					maxTeam = leftMen;
				}else if(womenTeam < leftMen && womenTeam > maxTeam) {
					maxTeam = womenTeam;
				}
			}
		}
		bw.write(String.valueOf(maxTeam));
		bw.flush();
	}
}
		
		
		/*
		int max = 0;
		int team=0;
		for(int i = 0; i < intern; i++) {
			int leftMen = men - i;
			int leftWomen = women-(intern-i);
			System.out.println("m: "+leftMen);
			System.out.println("w: "+leftWomen);
			if(leftMen > 0 && leftWomen > 1) {
				team = leftWomen / 2;
				if( team >= leftMen && max < leftMen) {
					max = leftMen;
				}else if (team < leftMen && max < team){
					max = team;
				}
			}
			System.out.println("max: "+max);
		}
		if(intern == 0) {
			team = women / 2;
			if( team >= men) {
				max = men;
			}else {
				if(max < team) {
					max = team;
				}
			}
		}
		System.out.println("max: "+max);
		bw.write(String.valueOf(max));
		bw.flush();
		
	}
}
*/

/*
 * 5 2 4 = 1
 * 4 2 1 = 1
 * 2 2 0 = 1
 * 8 3 5 = 2  
*/