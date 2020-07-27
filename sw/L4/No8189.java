
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No8189 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int letterNum = Integer.parseInt(st.nextToken());
			int maxNum = Integer.parseInt(st.nextToken());
			int maxTime = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>(); 
			for(int i = 0; i < letterNum; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			ArrayList<Integer> temp = new ArrayList<>();
			ArrayList<Integer> answer = new ArrayList<>();
			//1. 1001 이 아니라 2001로 한 이유
			for(int hour = 1; hour < 2001; hour++) {
				if (!q.isEmpty() && q.peek() <= hour) {
					temp.add(q.poll());
				}
				
				//2. size를 따로 저장해놓은 이유
				int size = temp.size();
				//3. if문에서 temp.size 확인하는 이유 
				if (temp.size() == maxNum || (temp.size() > 0 && hour - temp.get(0) == maxTime)) {
					for(int i = 0; i < Math.round(size/2.0); i++) {
						temp.remove(0);
						answer.add(hour);
					}
				}
				
				if(answer.size() == letterNum)
					break;
			}
			sb.append("#").append(tc);
			for(int i = 0 ; i < answer.size(); i++) {
				sb.append(" "+answer.get(i));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
/*
java 라이브러리 사용못해서 .. 어케 하는지..
1번
ex)
1
3 1000 1000
998 999 1000
최대 범위들을 고려하면 hour이 2000까지 가야 위 내용들이 적용됨. 최대 범위 고려 못함

2번
for문안 remove 때문에 size를 저장해놔야한다. 안 그러면 remove한 후  크기에 대해 round를 실행함
예외 케이스 생각하고 for문 조건문 범위 확인과 remove가 동시에 일어난다면 유의하기
ex)
2
10 6 5
0 1 2 3 4 5 6 7 8 9
3 11 10
1 10 11

3번
temp.get(0)에 아무것도 없을 수도 있다.		
ex)
1
3 1000 1000
998 999 1000
 */
