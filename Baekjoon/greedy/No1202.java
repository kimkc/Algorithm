package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1202 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] jNumNbagNum = br.readLine().split(" ");
		int jewelryNum = Integer.parseInt(jNumNbagNum[0]);
		int bagNum = Integer.parseInt(jNumNbagNum[1]);
		
		ArrayList<Jewelry> jewelries = new ArrayList<Jewelry>();
		int[] bags = new int[bagNum];
		for(int i = 0; i < jewelryNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			jewelries.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for(int i = 0; i < bagNum; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		 
		Collections.sort(jewelries);
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();  
		long sum = 0; //
		int j = 0;
		for(int i = 0; i < bagNum; i++) {
			while(j < jewelryNum && jewelries.get(j).weight <= bags[i]) {
				pq.add(-jewelries.get(j).price); //-왜인지 생각
				j++;
			}
			if(!pq.isEmpty()) {
				sum += Math.abs(pq.poll());// -와 연관
			}
		}
			/* 왜 이것은 안 되고 우선순위 큐가 될까? 코드의 동작에 엄청난 차이 있음, hint 우선순위 큐 최대만 없애고, 그 전에 값들을 가지고 있음(얘네가 더 클 수도 있음) 
			 * 이걸 어디 적용할 수 있을 지 생각!!! 원리 이해!
			int bagWeight = bags.get(i);
			int max = 0;
			int jwWeight = -1;
			int j = 0;
			while(jwWeight <= bagWeight && !jewelries.isEmpty()) {
				Jewelry jw = jewelries.get(j);
				jwWeight = jw.weight;
				if(max < jw.price) {
					max = jw.price;
				}
				jewelries.remove(j);
				j++;
			}
			sum += max;
		}
		*
		*/
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}

class Jewelry implements Comparable<Jewelry>{
	int weight;
	int price;
	
	public Jewelry(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
	
	@Override
	public int compareTo(Jewelry j) {
		if(this.weight > j.weight) {
			return 1; //오름 차순 
		}
		return -1;
	}
}
	/*
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] jNumNbagNum = br.readLine().split(" ");
		int jewelryNum = Integer.parseInt(jNumNbagNum[0]);
		int bagNum = Integer.parseInt(jNumNbagNum[1]);
		ArrayList<Jewelry> jewelries = new ArrayList<Jewelry>();
		ArrayList<Integer> bags = new ArrayList<Integer>();
		
		for(int i = 0; i < jewelryNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			jewelries.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for(int i = 0; i < bagNum; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}
		 
		Collections.sort(jewelries);
		Collections.sort(bags);
		
		int sum = 0;
		int i = 0;
		while(i < jewelryNum && !bags.isEmpty()) {
			Jewelry jw = jewelries.get(i);
			int index = Collections.binarySearch(bags, jw.weight);
			if( index > -1) {
				bags.remove(index);
				sum += jw.price;
			}else if(index < 0){
				if(-bagNum > index) { //제일 많은 무게를 넣을 수 있는 가방 무게보다 무거움
					i++;
					continue;
				}else if(-bagNum < index) {
					bags.remove(-(index+1));
					sum += jw.price;
				}
			}
			i++;
		}
		System.out.println(sum);
		
	}
}

class Jewelry implements Comparable<Jewelry>{
	int weight;
	int price;
	
	public Jewelry(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
	
	@Override
	public int compareTo(Jewelry j) {
		if(this.price < j.price) {
			return 1; //내림 차순 ( 만약 > 이면 오름차순)
		}
		return -1;
	}
}
*/