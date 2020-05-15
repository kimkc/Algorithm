package Baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6603_ {
	static int depth = 0; // 상태공간트리 깊이, 만들고자 하는 것의 크기=> -, +;
	//그래프에서는 visited는 모든 정점, 
	//visited를 false로 바꾸는 것을 곁들이면 백트래킹을 한다. 
	//상태공간트리로 확인해보기 백트래킹 재귀함수 문제 풀기
	public static void dfs(int now, String[] arr, String str) { //str같이 그때그때 만들어지는 것도 필요, 전역으로하면 그전게 다저장되서 안됨
		if(depth == 5) {
			System.out.println(str);
		}else {
			for(int i = now+1; i < arr.length; i++) {
				depth++;
				dfs(i, arr, str+arr[i]+" ");
				depth--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = -1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			if(num == 0)
				break;
			String[] arr = new String[num];
			for(int i = 0; i < num; i++) {
				arr[i] = st.nextToken();
			}
			
			for(int i = 0; i < arr.length; i++) {
				dfs(i, arr, arr[i]+" ");
			}
			System.out.println();
		}
		
	}
}
/*
배열이 아닌 문자열로 출력을 해도 된다.
조합은 중복이 없기에 상태트리로 for i~n , for i+1~n..까지 필요한 갯수까지 있으면 된다.
이를 상태공간트리로 보고, 깊이, 출력문의 문자나 배열 등(파라미터로 매번 전거까지만 만들어져잇음), i+1(다음)의 파라미터들로 만든다.
탈출문을 처음에 넣고 그때 필요한 처리를 한다. 그 다음, 매번 해야할 일들을 처리한다.
백트래킹을 위해 깊이나, 배열, visited등을 --, false등을 끝나면 처리하여 백트래킹한다.
항상 재귀시 어디로 들어가고 처리되는지 세밀히 봐야한다.
 */
