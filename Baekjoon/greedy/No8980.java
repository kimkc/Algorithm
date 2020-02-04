package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No8980 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cityNum = Integer.parseInt(st.nextToken());
		int limitNum = Integer.parseInt(st.nextToken());
		int[] truckStorage = new int[cityNum+1];
		int infoNum = Integer.parseInt(br.readLine());
		
		DeliverInfo[] infoes = new DeliverInfo[infoNum];
		for(int i = 0; i < infoNum; i++) {
			st = new StringTokenizer(br.readLine());
			infoes[i] = new DeliverInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(infoes);
		int sum = 0;
		for(int i = 0; i < infoNum; i++) {
			int get = 0;
			int from = infoes[i].recvFrom;
			int to = infoes[i].sendTo;
			int val = infoes[i].boxNum;
			
			for(int j = from; j < to; j++)
				get = Math.max(get, truckStorage[j]);
			
			get = Math.min(limitNum - get, val);
			sum += get;
			
			for(int j = from; j < to; j++) {
				truckStorage[j] += get;
			}
		}
		System.out.println(sum);
	}
}

class DeliverInfo implements Comparable<DeliverInfo>{
	int recvFrom;
	int sendTo;
	int boxNum;
	
	DeliverInfo(int rec, int sendTo, int boxNum){
		recvFrom = rec;
		this.sendTo = sendTo;
		this.boxNum = boxNum;
	}
	public int compareTo(DeliverInfo info) {
		if(this.sendTo > info.sendTo ) {
			return 1;
		}else if(this.sendTo == info.sendTo) {
			if(this.recvFrom > info.recvFrom) {
				return 1;
			}
		}
		return -1;
	}
}
/*
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cityNum = Integer.parseInt(st.nextToken());
		int limitNum = Integer.parseInt(st.nextToken());
		int[] truckStorage = new int[cityNum+1];
		int nowBoxNum = 0;
		int infoNum = Integer.parseInt(br.readLine());
		
		DeliverInfo[] infoes = new DeliverInfo[infoNum];
		for(int i = 0; i < infoNum; i++) {
			st = new StringTokenizer(br.readLine());
			infoes[i] = new DeliverInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(infoes);
		for(int i = 0; i < infoNum; i++) {
			System.out.println(infoes[i].recvFrom+" "+infoes[i].sendTo+" "+infoes[i].boxNum);
		}
		int sendedBoxNum = 0;
		int j = 0;
		for(int i = 1; i <= cityNum; i++) {
			
			//박스 전달 과정
			sendedBoxNum += truckStorage[i];
			nowBoxNum -= truckStorage[i];
			truckStorage[i] = 0;
		
			while(j < infoNum && infoes[j].recvFrom <= i) {	
				//박스를 넣는 과정
				if(limitNum < nowBoxNum+infoes[j].boxNum) {
					int available = limitNum-nowBoxNum;
					if(available == 0) {
						j++;
						continue;
					}
					truckStorage[infoes[j].sendTo] += available;
					nowBoxNum = limitNum; //limitNum = nowBoxNum+available;
				}else {
					truckStorage[infoes[j].sendTo] += infoes[j].boxNum;
					nowBoxNum += infoes[j].boxNum;
				}
				j++;
			}
		}
		System.out.println(sendedBoxNum);
	}
}

	
	public int compareTo(DeliverInfo info) {
		if(this.recvFrom > info.recvFrom ) {
			return 1;
		}else if(this.recvFrom == info.recvFrom) {
			if(this.sendTo > info.sendTo) {
				return 1;
			}
		}
		return -1;
	}
}
*/