package L3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No5431 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 0; i < testNum; i++) {
			String[] numOfStudentNSummit = br.readLine().split(" ");
			byte studentNum = Byte.parseByte(numOfStudentNSummit[0]);
			byte summitNum = Byte.parseByte(numOfStudentNSummit[1]);
			boolean[] students = new boolean[studentNum+1];
			String[] summitStudents = br.readLine().split(" "); 
		
			for(int k = 0; k < summitNum; k++) {
				students[Integer.parseInt(summitStudents[k])] = true;
			}
			
			bw.write("#"+(i+1));
			for(int x = 1; x < studentNum+1; x++) {
				if(students[x] == false)
					bw.write(" "+x);
			}

			bw.write("\n");
			bw.flush();
		}
	}
}

