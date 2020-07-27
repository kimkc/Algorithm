package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9251 {
	public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = 0; i < str1.length(); i++) {
        	for(int j = 0; j < str2.length(); j++) {
        		
        		if(str1.charAt(i) == str2.charAt(j)) {
        			dp[i+1][j+1] = dp[i][j+1] + 1;
        		}else
        			dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
        	}
        }
        System.out.println(dp[str1.length()][str2.length()]);
	}
}
/*
Q
1. 해당 이차원 배열의 인덱스들이 나타내는 의미 

2. 같은 경우
 해당 위치 = 위 값 + 1
 => 왼쪽 +1 해도 되지 않나? 항상 위나 왼쪽이나 해당 문자열 전까지의 최대값을 가지고 있으니까
 => 둘다 안됨 해당위치 = 왼쪽 대각선 + 1 
 
3. 틀릴 경우
 해당 위치 = max(왼쪽, 위쪽)

4. 부분 수열을 출력하는 법

5. 최장이 여러개 일 경우가 있나?? 그땐 어떻게?

6. 더 효율성을 높일 수 있는 방법( 접미부가 같은 경우들 빼기, 짧은 문자열을 대비 등? 위키백과 참조)
 
A
1. 현재까지 문자열의 LCS를 나타냄

2.
위
capck aa => 2
왼 
aa capck => 2
1(인덱스의 의미를 생각하면 왼이나 위를 하면 열이나 행에 현재 이미 +1된 것에 또 +1을 하게 되는 경우가 발생한다.
순서가 다르고 길이가 달라서 그것이 안나타나 보였을 뿐이다.
 => 둘다 안됨 해당위치 = 왼쪽 대각선 + 1 
 
2.3.왜 위와 같은 경우가 되는 지 설명할 줄 알기
같은 경우: 현재 값이 같으니 최댓값 유지한 이전 인덱스(왼,오 = 현재를 제외한 이전 문자열의 길이) + 1
틀릴 경우: dp로 항상 lcs의 최댓값 유지한다

4. 
같은 경우 +1이 되는 경우를 따로 dp 외 배열에 1로 표시(최초로 바뀌는 부분들이 부분 수열의 값 = 2를 이해하면 됨)
문자열 값들을 순서대로 출력
*/
