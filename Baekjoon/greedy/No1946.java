package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 지원자만큼의 배열을 만들고, 해당 인덱스를 면접점수로 두고 값을 서류 점수로 둔다.
 * 면접등수는 정렬될 것이고, 서류 등수는 정렬된 면접 등수를 인덱스로 값을 가지게 된다.
 * 면접 등수가 정렬되어 있으므로 첫번째가 선택되면 면접등수는 1등이므로 그 뒤부터는 무조건 낮은 등수이다.
 * 그러므로 첫번째 면접 점수에 해당하는 서류 등수가 선택되면 그 다음 서류 등수는 무조건 전 등수보다 높아야(등수니까 작은 정수가 높은 것) 한다.
 * 첫번째부터 차례로 선택되면 그 다음 작은 것들이 몇개 선택되는지를 그리디의 선택으로 하면 된다.
 * 최악의 경우 시그마 1~100,000번 걸린다.5,000,050,000‬
 * 근데 초반부에 중간 등수보다 높은 등수가 나오면 나머지는 대부분 낮은 등수들 밖에 없으니 선택이 안되는데 이 부분을 처리해주면 더 빨라질 거 같은데 ....제대로 모르겠다
 * 이 풀이법도 구글을 통해 본 것이기에...
 *  => 역시나 시간 초과 난다. 테스트 케이스에 또 빠져서 넓게 생각 못함..
 */
public class No1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0; i < testCase; i++) {
			int applyNum = Integer.parseInt(br.readLine());
			int[] interviewNdocument = new int[applyNum+1];
			
			for(int j = 0; j < applyNum; j++) {
				String[] interNdoc = br.readLine().split(" ");
				interviewNdocument[Integer.parseInt(interNdoc[0])] = Integer.parseInt(interNdoc[1]);
			}
			
			/* 무조건적으로 before보다 작은 것을 선택하면 최대 수를 구할 수 없다.
			 * 8,1,4,9,6/3,5,10,2,7 8을 선택시 그 다음 1이냐 아니냐에 따라 달라진다.
			 * 그렇다고 하나를 선택하고 그다음 또 최대를 뽑을 수 잇는것을 하나하나 선택하게되는 것은 완전 검색에 너무많은 시간이 걸린다.
			 */
			/*
			for(int j = 0; j <= applyNum; j++) {
				int before = 100001;
				int count = 0;
			*/// 이과정이 왜 필요없지? 처음 서류1 순위라면 무조건 얘를 뽑는게 최적일 수 밖에 없는 이유를 정확히 모르겠다. 대략 그런 거구나 밖에는.. 그래서 뒤에도 다 찾아봐야한다 생각했는데
				int before = interviewNdocument[1];
				int count = 1;
				for(int x = 2; x <= applyNum; x++) {
					if(before > interviewNdocument[x]) {
						before = interviewNdocument[x];
						count++;
					}
				}
				bw.write(String.valueOf(count)+"\n");
				bw.flush();
			}
			
			
			//초반 절반 그 중 제일 큰 수를 구하고 그것부터 돌리며 된다. 왜 절반? 초반 절반 중 제일 큰 수를 구하면 그 부분부터 중간 다음 애들을 최대한 포함 할 수 있다.
			//중간 다음에 제일 큰 수는? 그래봤자 중간 다음중에 최대한 포함 하기 때문에 중간이전에 제일 큰 수를 구하는 것이 제일 이득이다.
			//그렇다면 중간 이전 n=10이라면 1-5중에 제일 큰 수가 8인데 4자리에 있고, 10 4,5,6,7,8,10,9,3,2,1 이런 경우 안됨
			// 그렇다면 초반 중간 제일 큰 수, 그 다음 중간에서 제일 큰수 그하고 거기서 부터 각자 하고 제일 많은 애를 구하면 되지 않나?
			//8,1,4,9,6/3,5,10,2,7	
	}
}
