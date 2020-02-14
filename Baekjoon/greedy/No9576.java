package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No9576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int bookNum = Integer.parseInt(st.nextToken());
			int studentNum = Integer.parseInt(st.nextToken());
			
			boolean[] availableBook = new boolean[bookNum+1];
			Student[] students = new Student[studentNum];
			
			for(int i = 0; i < studentNum; i++) {
				st = new StringTokenizer(br.readLine());
				students[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int result = 0;
			Arrays.sort(students);
			for(int i = 0 ; i < studentNum; i++) {
				System.out.println(students[i].a+" "+students[i].b);
			}
			for(int i = 0; i < studentNum; i++) {
				for(int j = students[i].a; j <= students[i].b; j++) {
					if(!availableBook[j]) {
						availableBook[j] = true;
						result++;
						break;
					}
				}
			}
			System.out.println(result);
			
		}
	}
}

class Student implements Comparable<Student>{
	int a;
	int b;
	
	Student(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int compareTo(Student o) {
		if(this.b < o.b) {
			return -1;
		}else if(this.b > o.b) {
			return 1;
		}else{
			if(this.a < o.a) {
				return -1;
			}
		}
		return 0;
	}
}
