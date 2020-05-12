import java.util.*;
class Solution {
    static int[] priors = new int[10];
    
    public boolean isPrior(int prior){
        for(int i = 9; i > prior; i--){
            if(priors[i] > 0)
                return false;
        }
        return true;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0; 
        ArrayList<Doc> docs = new ArrayList<>();
         for(int i = 0; i < priorities.length; i++){
            priors[priorities[i]]++;
            docs.add(new Doc(i, priorities[i]));
         }
        
        while(true){
            int pr = docs.get(0).priority;
            if(isPrior(pr)){
                int loc = docs.remove(0).loc;
                priors[pr]--;
                answer++;
                if(loc == location)
                    break;
            }else{
                docs.add(docs.remove(0));    
            }
        }
        return answer;
    }
}

class Doc{
    int loc;
    int priority;
    Doc(int loc, int prior){
        this.loc = loc;
        this.priority = prior;
    }
}

//2020.5.12 12:49 ~ 13:01,  13:01~19, ~1:40
//문제 해석 잘못  1:20~26
//1~9까지 배열, 배열[우선순위]++;
//객체 loc,우선순위를 arrayList에 담음
//매번 앞에서 뽑고 해당 우선순위까지 우선순위arr를 돌려 다 하나라도 1이상이면 false를 다 돌면 true로 우선순위없다는걸 알려준다.
//순서에 대한 실수
// 1. while문을 돌때마다 answer(순서)++ 생각 없음, 정렬시 안정성이 있어도 compare시 안정성이 고려될지 모름
// 2. 최대값을 구하면 정렬된다 생각
// 3. 1,2를 토대로 우선순위를 만나면 삭제하고 순서++해주며 삭제되는 순간의 순서를 출력해줌 (시뮬레이션)

//단순화 가능할 것 같다.
//other code)
/*
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--; //l < 0이 어떻게 해서 답이 출력되는데 도움이 되는지 모르겟다
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
*/
