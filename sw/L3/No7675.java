package L3;
/*
2
2
Annyung Hasae Yo! LoL!
3
my name is Hye Soo. my id is
Rhs0266. what your id Bro?
		

#1 3 0
#2 2 0 1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No7675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i=0; i<testCaseNum; i++) {
			
			int phraseNum = Integer.parseInt(br.readLine());
			String[] phrasies = br.readLine().split("\\!|\\.|\\?"); // | \\.$ | \\?$ �����ϸ� �ȵǰ� �ٿ�����
			
			System.out.print("#"+(i+1)+" ");
			for(int j = 0; j < phrasies.length; j++) {
				//System.out.println(phrasies[j]);
				String[] words = phrasies[j].split(" ");
				//words[words.length-1] = words[words.length-1].replaceAll("\\!|\\.|\\?", "");  split()�� �ڵ����� ���ڿ��������� ������ �ش� ���ڿ��� �ڸ�
				//System.out.println(words[words.length-1]);
				
				String nameRegExp = "^[A-Z][a-z]*$";
				int count = 0;
				
				for(int k = 0; k < words.length; k++) {

					if(words[k].matches(nameRegExp)) {
						count++;
					}
				}
				
				if (j == phraseNum-1) {
					System.out.println(count);
				}else {
					System.out.print(count+" ");
				}
			}
		}
	}
}
