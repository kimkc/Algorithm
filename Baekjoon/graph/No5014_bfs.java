package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5014_bfs {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int finish = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int[] upNdown = new int[2];
		upNdown[0] = Integer.parseInt(st.nextToken());
		upNdown[1] = -Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[1000001];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		
		int count = 0;
		boolean isAnswer  = false;
		
		while(!q.isEmpty()) {
			int qLen = q.size();
			
			while( qLen > 0) {
				int now = q.poll();
				//���⼭ visited check�� �߾���.
				if(now == goal) {
					isAnswer = true;
					break;
				}
			
				for(int i = 0; i < 2; i++) {
					if( now+upNdown[i] >= 1 && now+upNdown[i] <= finish && !visited[now+upNdown[i]] ) {
						q.add(now+upNdown[i]);	
						visited[now+upNdown[i]] = true; // ���⼭ true�� ���ϸ� ���� for������ �ߺ��� �� �ִٸ� q�� �ְ� �ȴ�.
						
					}
				}
				qLen--;
			}
			if(isAnswer) {
				System.out.println(count);
				break;
			}
			count++;
		}
		if(!isAnswer) 
			System.out.println("use the stairs");
	}
}
