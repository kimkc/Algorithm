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
		for(int i = n-1; i >= 0; i--){ //n-1, i--�� /2�� ������ �Ͱ� ����
			int idx = (int)(Math.pow(2,i)); // /2���� 1�� ����� ������ ���� ��
			int now = idx-1; //��Ʈ, ���� Ʈ���� ��Ʈ �ε���
			while(now < line.length){  //��Ʈ, ���� ����Ʈ�l�� ��Ʈ �湮 ǥ�ÿ� ���,
				if(vis[now] == 0){
					vis[now] = 1;
					bw.write(line[now]+" ");
				}
				now+=idx; //�̿� vis�� ���� ������ ����Ʈ�� ���, �Ŀ� ��ü ��µ��� ���� �͹̳� ��� ��µ� ����
			}
			bw.write("\n");
		}
	}
	bw.flush();
}
 */

