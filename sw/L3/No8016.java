package L3;
/*
 배열 생각, 배열 인덱스=위치, 값=홀수값 => memoryOver
 규칙과 공식: 2n+1 사용하여 위치에 따른 홀수 값 찾기, 모든 홀수 더하기 공식 
ex) 5층이면 2(5-1)+1=9은 해당 층의 홀수값 갯수들, 
9를 포함하지 않는 8까지의 홀수값들을 합(그 전층들 갯수[2n+1공식에 대입할위 치를 알기 위해]) 8/2=4*4=16
 그 전층들 위치 다 더한 위치가 왼쪽 값: 2(16)+1 
 그 전층들 다 더하고 그 층의 갯수를 더한 것에 -1 위치가 오른쪽값: 2(16+9-1=24)+1 : -1을 안 하면 그다음 값이됨
 */
import java.util.Scanner;

public class No8016 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TCN = sc.nextInt();
		for(int i=0; i < TCN; i++) {
			int TC = sc.nextInt();
			System.out.print("#"+(i+1)+" ");
			if( TC == 1) {
				System.out.print(1+" ");
				System.out.print(1+" ");
			}else {
				long NumOfLayer = 2*(TC-1)+1;
				long beforeLaySum = ((NumOfLayer-1)/2)*((NumOfLayer-1)/2); 
				long leftVal = 2*(beforeLaySum)+1;
				long rightVal = 2*(beforeLaySum+NumOfLayer-1)+1;
				System.out.print(leftVal+" ");
				System.out.print(rightVal+" ");
			}
			System.out.println();
		}
	}
}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String args[]) throws Exception{
 
        int Test = Integer.parseInt(br.readLine());
 
        for(int T = 1; T <= Test; T++)
        {
            Long Line = Long.parseLong(br.readLine());
            Long mid = (2 * Line * Line) - (2 * Line) + 1;
 
            sb.append("#"+T + " " + (mid - (Line - 1) * 2) + " " + (mid + (Line - 1) * 2)+"\n");
 
        }
        System.out.print(sb.toString());
    }
}
*/