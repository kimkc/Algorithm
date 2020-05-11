//2020.05.11
// 접근 6:16~26, 구현 7:15~30, 디버깅 7:35-54
//count
//while(!array.isemplt)
//for문 돌며 각각 progress.set(i, progress.get(i)+speeds.get(i))
// progress.get(0) 이 100이 안 넘을 때까지 count++, 넘는 것 remove() 후 answer에 count 담음  
import java.util.*;
class Solution {
     public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> days = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> speed = new ArrayList<>();
        for(int i = 0 ; i < progresses.length; i++){
            arr.add(progresses[i]);
            speed.add(speeds[i]);
        }
        
        while(!arr.isEmpty()){
            int day = 0;
            boolean isInsert = false;
            for(int i = 0 ; i < speed.size(); i++){ // speeds배열은 삭제되지 않으므로 인덱스 에러가 난다.
                arr.set(i, arr.get(i)+speed.get(i));
            }
            while(!arr.isEmpty()){
                if(arr.get(0) >= 100){
                    arr.remove(0);    
                    speed.remove(0);
                    isInsert = true;
                    day++;  
                }else{
                    break;
                }
            }
            if(isInsert)
                days.add(day);
        }
        answer = new int[days.size()];
        for(int i = 0; i < days.size(); i++){
            answer[i] = days.get(i);
        }
        return answer;
    }
}

//코딩하며 오타나는 부분을 디버깅하지 않으니 캐치 못함 -> 시간 소요
//eclipse로 테스트환경 만들고 디버깅하기 => 디버깅에 많은 시간을 사용
//other code) 
//단순화를 잘 시킴, day를 인덱스로 하는 배열을 만들고, 각 순서당 progresses[i]+ day*speeds[i] > 100 일 때 days[day]++해준다.
// 진행과 속도의 값을 바꾸지 않고, day만 ++해주며 곱해주면 값을 구할 수 있다. 처음부터 하기에 처음 배포가 안되면 그 다음 것도 안된다는 규칙도 지킬 수 잇다.
//그러면 days의 0인덱스부터 answer리스트에 넣으면 날짜 순으로 리턴하면 된다.
