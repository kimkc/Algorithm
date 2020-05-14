class Solution {
    public long gcd(long w, long h){
        long r = 0;
        while (h !=0 ){
            r = w % h;
            w = h;
            h = r;
        }
        return w;
    }
    
    public long solution(int w, int h) {
        long answer = 1;
        long wl = Long.parseLong(String.valueOf(w));
		long hl = Long.parseLong(String.valueOf(h));
		
        answer = (wl*hl) -(wl+hl-gcd(wl,hl));
        return answer;
    }
}

/*
2:33~2:44
1억 이하라면  dfs, bfs보단 어떠한 규칙이 있다.
1. w와 h 짝수, 홀수 일 때 규칙이있다 생각했지만 이는 w와 h가 큰 차이가 없을 때만이다..
other code)
최대공약수를 통해 문제를 해결하였다. 위 2차원 배열은 y=x로도 나타낼 수 있다.
또한 패턴이 반복되는 각 사각형의 규칙적인 블록은 w/gcd*h/gcd의 크기의 사각형이다. 최대공약수로 나눈 값만큼 사각형이 있다.
이 사각형에서 대각선이 지나가는 사각형의 갯수를 구하려면 생각해보고 규칙을 본다.
이를 위해 w+h-1을 구하면 값이 나온다.
그 이유는 N*M크기의 블록을 대각선으로 자를때, 반드시 가로는 N만큼, 세로는 M만큼 가야하기 때문이다.
( 사각형을 대각선으로 자르면 왼쪽맨위끝~ 오른쪽 맨아래 끝으로가는데 그때 최대가로는 N, 최대세로는 M이니깐 !! )
그래서 대각선으로 자르면 가로N, 세로M만큼가서 N+M을하게되는데, 가로로 갈때랑 세로로 내려갈때 시작점은 똑같기때문에 중복이라서 -1을 해주는것이다 !!
*/
