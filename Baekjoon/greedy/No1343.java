package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//�� �����Ҵµ� .���� �����ϸ� �������� ������. ...XX�� ....XXXX�Ǿ���
		//XXXXXX	...X	..XXXX.XX..XX	
		String board = br.readLine();
		int[] xNums = new int[200];
		boolean isExist = true;
		boolean isNextDot = true;
		//boolean existDot = false;
		//int isOnlyDot = 0;
		int xIndex = 0;
		int count = 0;
		for(int i = 0; i < board.length(); i++) {
			if(board.charAt(i) == 'X') {
				count++;
				isNextDot = true;
				/*if(board.length()-1 == i && !existDot) {
					xNums[xIndex] = count;
				}else*/ if(board.length()-1 == i) {
					if(count % 4 == 1 || count % 4 ==3) {
						isExist = false;
						bw.write("-1");
						break;
					}
					//if(isOnlyDot == 1) {//
					//	xNums[xIndex-1] = count;//
					//}else {//
						xNums[xIndex] = count;
					//}//
					}
			}else if(board.charAt(i)=='.' && isNextDot){
				//existDot = true;
				//isOnlyDot++; //...XXXX�긦 ����.. ���İ�Ƽ�ڵ��..
				if(count % 4 == 1 || count % 4 ==3) {
					isExist = false;
					bw.write("-1");
					break;
				}
				xNums[xIndex] = count;
				if(count != 0) { // ..������ ��
					xIndex++;
				}
				count = 0; isNextDot = false;
				
			}
		}
		
		
		if(isExist) {
			boolean isNextX = true;
			xIndex = 0;
			for(int i = 0; i < board.length(); i++) {
				if(board.charAt(i) == 'X' && isNextX) {
					isNextX = false;
					int xNum = xNums[xIndex];
					xIndex++;
					if(xNum % 4 == 0 && xNum >= 4) {
						for(int j = 0; j < xNum; j++) {
							bw.write("A");
						}
					}else if(xNum % 4 ==2 && xNum >= 4) {
						for(int j = 0; j < xNum-2; j++) {
							bw.write("A");
						}
						bw.write("BB");
					}else if(xNum < 4) {
						bw.write("BB");
					}
				}else if(board.charAt(i) == '.') {
					bw.write(".");
					isNextX = true;
				}
			}
		}
		bw.flush();
	}
}
