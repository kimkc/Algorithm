import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //순서대로이기에 트럭 객체를 만든 후 다리 q에 넣어주고 현재 무게를 갱신한다. 매번 시간과 비교하며 먼저들어온 트럭의 end시간이 되면 삭제시키고 현재 무게를 갱신한다. 
        int s = 1;
        int j = 0;
        bridge_length = bridge_length-1;
        int nowWeight = 0;
        Queue<Truck> q = new LinkedList<>();
        //while(j == end && que.isempty)
        while(true){
            //배열[j] + 현재 무게 && j < j.length <= weight => 다리Q에 추가, 현재무게+배열[j]; 시간Q에 s+(len-1추가); s++; j++; continue;
            if(j < truck_weights.length && truck_weights[j] + nowWeight <= weight){
                q.add(new Truck(truck_weights[j], s+bridge_length));
                nowWeight += truck_weights[j];
                //s++; 
                j++;
                //continue;
            }
            if(q.isEmpty()){
                break;
            }// 위치 중요
            // s == 시간que(0).end -> 다리q.remove(), 현재무게 -= 0무게
            if(s == q.peek().endTime){
                Truck t = q.poll();
                nowWeight -= t.weight;
                
            }
            /*
            if(j < truck_weights.length && q.isEmpty()){
                break;
            }
            */
            s++; // 위치 중요
        }
        
        answer = s;
        return answer;
    }
}

class Truck{
    int weight;
    int endTime;
    Truck(int w, int e){
        this.weight = w;
        this.endTime = e;
    }
}

//5:25~6:00, 6:03~6:15 6:34~39, 6:40~6:55
//** for : 컬렉션같은 경우 이런 for문이 더 보기 편하다. 변수에 get()나 iterator를 사용하여 대입하는 코드가 필요없음
//**항상 재귀, while문의 return, break문의 위치는 흐름상 어디에 있냐에 따라 결과가 달라짐으로 중요하다. 또한 배열의 인덱스를 포인터로 접근할 경우에 배열의 범위를 항상 고려해주어야한다.
//while(true)를 통하여 증가시키며 break문을 하는 경우 답을 증가시키는 위치도 break문에 따라 결과가 달라진다. 
//if문 후에 break문, poll, s++를 순서대로 해야 제대로 된 결과를 얻을 수 있다. 그렇지 않으면 q가 다른 트럭을 싣기 전에 잠시비워졌을 때 break문이 실행된다. 또한 s++가 된 다음 break가 실행될수도 있다. 첫번째 if문에서 s++과 continue는 안해도 뒤 s++에서 동작을 하게 된다.
//other code) 초가 아닌 큐에 들어있는 이동큐의 이동횟수를 증가시켜 다리보다 길어지면 이동큐에서 삭제하는 식으로 접근하였다. 매번 큐에 이동큐에 들어있는 트럭들의 이동거리를 다 하나씩 증가시켜줘야하고, answer 초도 또 증가시켜줘야한다. 하지만 초+다리길이로 도착시간을 알고 이를 통해 삭제시켜주는 것은 상수시간이 걸린다.
