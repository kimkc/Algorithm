import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TestCase; tc++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r =  Integer.parseInt(st.nextToken());
            if ( r > n/2 )
                r = n - r;
            
            int[] ns = new int[n-r];
            int[] rs = new int[r];
            
            int nValue = n;
            int rValue = r;
            //n과 r의 갯수는 같다
            for (int i = 0; i < r; i++)
            {
                ns[i] = nValue--;
            	rs[i] = rValue--;
            }
            
            for (int i = 0; i < r; i++)
            {
                for (int j = 0; j < r; j++)
           		{
                	if (ns[j] % rs[i] == 0)
                    {
                       ns[j] = ns[j] / rs[i];
                        rs[i] = 1;
                        break;
                    }
            	}
            }
            
            int np = 1;
            int rp = 1;
            for (int i = 0; i < r; i++)
            {
           		np *= ns[i];
                np %= 1234567891;
            }
                
            for (int i = 0; i < r; i++)
            {
           		rp *= rs[i];
                rp %= 1234567891;
            }
            System.out.println("#"+tc+" "+np/rp);
        }
    }
}

/*
n과 r의 배열(크기n-r, r)을 만든다. ( r > n/2 라면 n, n-r의 배열을 만든다)
r에서 n을 돌아가며 나눈다. (n % r == 0, r[] =1, n = n/r) 이때, 최대 공약수로 나눈 것은 생각하지 않음
n을 곱하며 1234567891을 넘어가면 나눈나머지, 구하고, r도 똑같이해주고 둘을 나누어준다
시간 초과

=> 페르마의 소정리
https://onsil-thegreenhouse.github.io/programming/problem/2018/03/29/problem_math_power/
https://5stralia.tistory.com/4
*/
