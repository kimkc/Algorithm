//2020.5.11
//아이디어 소요시간 50분
//구현 시간:10분
//( 다음 인덱스의 값이 )가 아니면 스택에 넣는다. 막대 한개 추가
//( 다음 값이 )라면 레이저이므로 막대 갯수에 스택에 있는 막대 수를 더해준다. 레이저로 인해 막대들이 2개로 나누어짐
// )를 만나면 스택의 최근 막대를 없앤다. 길이가 끝났기 때문에 레이저를 만나도 2개로 나누어지지 않는다.
import java.util.*;
class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        //(((()())(())()))(())
        while(i < arrangement.length()){
            if(arrangement.charAt(i) == '(' && arrangement.charAt(i+1) == ')'){
                answer += stack.size();
                i++;
            }else if(arrangement.charAt(i) == '(' ){
                stack.push(arrangement.charAt(i));
                answer += 1; //
            }else if(arrangement.charAt(i) == ')' ){
                stack.pop();
            }
            i++;
        }

        return answer;
    }
}


// 21번째줄 놓쳤었다. (를 만나 막대를 추가를 해야 그 다음 레이저()를 만나면 그 갯수만큼 더 추가 할 수 있다.
// other code를 보면 stack에 integer형으로 i의 값을 추가하고, )를 만나면 top+1 == i라면 레이저로 막대 갯수에서 -1을 한 후 크기를 더해준다.
// stack.size()가 아닌 int형 변수에 바로 담아서 갯수를 구할 수 도 있다.
// 왜 stack을 사용했는가? 괄호가 힌트이고, 괄호 문자가 아니어도 막대기의 갯수와 레이저를 만났을 때 막대기의 갯수를 구하려면 스택형 자료구조가 알맞다.
// 아래 막대가 항상 추가되는 막대보다 길다. => 안쪽(오른쪽)에 있는 막대일수록 길이가 짧으므로 먼저 끝나는 특징 때문? 최근에 들어온 것과 현재 들어오는 값과의 비교가 필요
//** 이 문제를 보고 왜 스택을 떠올렸는가??
