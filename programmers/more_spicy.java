import java.util.*;
class Solution {
    //문제 제대로 분석 못하고, 내 마음대로 설계를 함** 배열의 갯수 줄어듬, 스코빌 연산 규칙, k이상인 것도 연산에 포함 들을 빼먹고 생각
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K){ //*조건문 최소 값이 k이상이면 전부 다 k 이상인 것
            if(pq.size() == 1){ // 합치면 2개가 1개가 됨. 계속 조건이 만족 안 되면 합쳐지며 k이하인 원소가 1개가 남게됨 {1,1,4} K=100
                return -1; 
            } 
            int temp = pq.poll()+(pq.poll()*2);
            pq.add(temp);
            answer++;
        }
        
        return answer;
    }
    
        /*
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < scoville.length; i++){
            //if(scoville[i] < K){  //잘못됨 {1,10} 5이면 가능하지만 이때, arr의 원소에 1밖에 없으므로 연산못함,
                arr.add(scoville[i]);
            //}
        }
        Collections.sort(arr);
        long lastScoville = 0;
        int i = 0;    
       //즉, [i]와 [i+1] >= k: 그 다음 i+=2, last에 저장 last가 항상최소거나 최소 다음이면 상관없지만 그렇지 않으면 이는 scoville 연산법칙에 어긋남
        //        < k: last+[i] 넘을 때까지 i+1, 넘으면 last 갱신, i++; //last로 갱신하면 안됨 이미 최소 값이 아닌 경우 일 수 있다. 매번 정렬하면서 최소값+최소다음값*2을 해주고 값을 넣고 정렬해야한다. k이하 이상으로 나눌 필요가 없다. 힙과 같은 원리인데 배열로 하면 속도가 비효율적이다.
        //count++
        while(arr.get(0) < K){
            if(arr.size() == 1){
                return -1;
            }
            int temp = arr.remove(0)+(arr.remove(0)*2);
            arr.add(temp);
            Collections.sort(arr);
            answer++;
            /*
            long s = arr.get(i)+(arr.get(i+1)*2);
            if(s >= K){
                i += 2;
                lastScoville = s;
                answer++;
            }else{
                i++;
                while(i < arr.size() && s < K){
                    i++;
                    s += (arr.get(i)*2);
                    answer++; //
                }
                lastScoville = s;
                i++;
            }
        }
        if (lastScoville < K){
            return -1;
        }
        if(i < arr.size()){
            answer += arr.size()-i;
        }
        
        }
        return answer;
    }  --> arrayList 효율성 통과 x
    */
}

/*
5-15 9:02~ 9:15, 9:18~34, 어떤 부분에서 논리적 오류가 생기는 지 모르겠다.
=> 자료구조에 대한 공부 부족, 힙을 사용하면 되는데 활용할 줄 모름
**배열 vs 힙 vs 이진 검색 트리 에서 왜 힙을 사용할까? 
-나는 배열 형식으로 매번 포인터를 사용하는 것에 익숙해 이번에도 배열의 포인터를 이용하여 해결하려하였다.
=> 테스트 케이스에만 적용되고, 틀린걸 보니 구현이 잘못되었거나 문제를 제대로 이해못해 테스트케이스 예상을 못하겠다. => 최신 scoville을 저장해놓고 계속 더해주는 것이 최소횟수가 아니다. 그것이 크다면 그 위치에 넣어주어야하고, 섞은 스코빌 지수는 **항상 가장맵지 않은 음식의 스코빌 지수와 두번째 스코빌 지수들로만 연산이 되어야한다(배열은 그럴려면 항상 정렬해줘야함, 나는 정렬안함). 그렇기에 연산 후 적절한 위치에 넣어주어야한다. -> 그래서 최소 힙을 사용해야하는 것이다. O(최솟*nlogn)
-힙은 위처럼 매번 포인터로 값을 구하고 비교하고, 포인터를 옮기고 할 필요 없다. 최소힙, 최대힙을 자바 PriorityQueue를 통해 값들을 집어 넣고, 값을 빼면 *알아서 제일 작은 것이 순서대로* 나오고 연산하고 집어넣으면 구현 없이 알아서 최소만 제일 앞에 오게 된다. 이로 인해서 최소 값이 k이상이 될 수 있도록 모든 것이 연산을 쉽게 해준다. 위처럼 배열 인덱스를 가지고 k이상일 때와 이하일 때를 고민할 필요가 없다.
  이외에도 poll()+poll()*2를 했을 때 k미만 중간 값이 나오면 뒤로 가고, 제일 작은 값들끼리 계속 연산되며 제일 작은 것과 그 다음 작은 것들만 연산되며 *최소*횟수가 실행된다. 배열은 제일 작은 값을 알기 위해 새로운 값을 대입하고 정렬해야한다. O(nlogn)
-이 문제에서 이진트리 대신에 힙을 사용한 이유는 항상 제일 작은 것들만 있으면 되지 어떠한 검색이 빠르게 필요한 것이 아니기 때문이다. 작은 것들을 다시 정리하는데는 시간이 걸리지만 뽑는 데는 상수시간이 걸린다. 또한 뽑은 것을 다시 넣었을 때도 이진 정렬이 필요한 것이아니라 최솟값만 제일 루트에 있으면 되기 때문이다.

정렬이 되어있다는 가정하에, k이하의 배열을 만든다.
처음과 두번째를 섞고, 나온 것을 그 다음 것과 섞는 방법이 최소 아닐까?
k이하가 짝수개가 있다면 n/2번~n-1번이 될 수 있다.
홀수개 있다면 n-1개
즉, 무조건 2개해서 k 이상이면 없애고, 임시저장해둔다 마지막 스코빌점수를
그리고 1개가 남거나 다음 짝수개의 조합이 안넘으면 마지막 스코빌 점수를 섞어준다.
넘으면 마지막 스코빌 점수 갱신, 안넘으면 그 다음 것을 섞어준다.
즉, [i]와 [i+1] >= k: 그 다음 i+=2, last에 저장
                < k: last+[i] 넘을 때까지 i+1, 넘으면 last 갱신, i++;
    count++
*/
