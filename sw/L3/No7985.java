package L3;

import java.util.Scanner;

public class No7985 {

	public static void spli(int n, int end) {

		//if( n % 2 == 1) return;
		//System.out.println(n);
		//spli(n/2,end);
		//spli((n+end+1)/2, end);
		System.out.println(n);
		int left = n/2;
		int right = (n+end+1)/2;
		System.out.print(left);
		System.out.print(" ");
		System.out.print(right);
		System.out.println();
		for(int i =0; i < end/2; i++) {
			if(left % 2 ==0) {
				System.out.print(left/2);
				System.out.print(" ");
			}
			if(right % 2 == 0) {
				System.out.print((right+end)/2);
				System.out.print(" ");
			}
			left = left/2;
			right = right/2;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int end = sc.nextInt();
		int n = (end+1)/2;
		spli(n, end);
	}
}




//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

//8 4 12 2 6 10 14


/* ohterPeople
public static void main(String[] args) throws NumberFormatException, IOException{
	BufferReader br = new BufferedReader( new InputStreamReader(System.in));
	BufferWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
	
	int T,n,cnt;
	T=Integer.parseInt(br.readLine());
	String[] line;
	int[] vis;
	int[] temp;
	
	for(int t = 1; t <= T; t++){
		n = Integer.parseInt(br.readLine());
		line = br.readLine().split(" ");
		vis = new int[line.length];
		bw.write("#" + t +" ");
		for(int i = n-1; i >= 0; i--){ //n-1, i--는 /2로 나누는 것과 같음
			int idx = (int)(Math.pow(2,i)); // /2보다 1을 만들수 있으니 좋은 듯
			int now = idx-1; //루트, 서브 트리의 루트 인덱스
			while(now < line.length){  //루트, 왼쪽 서브트릐의 루트 방문 표시와 출력,
				if(vis[now] == 0){
					vis[now] = 1;
					bw.write(line[now]+" ");
				}
				now+=idx; //이와 vis를 통한 오른쪽 서브트리 출력, 후에 전체 출력되지 않은 터미널 노드 출력도 가능
			}
			bw.write("\n");
		}
	}
	bw.flush();
}
 */

