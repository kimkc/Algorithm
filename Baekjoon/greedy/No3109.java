import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No3109 {
	static int count = 0;
	static int row;
	static int column;
	static char[][] map;
	static int[][] yNx = {
	{-1, 1},
	{0, 1},
	{1, 1}};
	
	static boolean dfs(int y, int x) {
		if(x == column-1) {
			return true;
		}
		map[y][x] = 'x';
		
		for(int i = 0; i < 3; i++) {
			int ny = y+yNx[i][0];
			int nx = x+yNx[i][1];
			if(ny >= 0 && row > ny && nx >= 0 && column > nx) {
				if(map[ny][nx] == '.') {
          //map[y][x] = 'x';
					boolean flag = dfs(ny,nx);
					if(flag){
						return true;
					}//else map[ny][nx] = '.'
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		map = new char[row][column];
		for(int i = 0; i < row; i++) {
			String input = br.readLine();
			for(int j = 0; j < column; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for(int i = 0; i < row; i++) {
			if(dfs(i,0))
				count++;
		}
		
		System.out.println(count);
	}
}
