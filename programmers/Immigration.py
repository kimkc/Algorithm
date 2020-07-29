def solution(n, times):
    answer = 0
    left = 1
    right = max(times)*n
    answer = right
    
    #left, right, mid, Sum Q
    while left <= right:
        mid = (left+right)//2
        Sum  = 0
        for time in times:
            Sum += mid//time
        
        if Sum < n :
            left = mid+1
        else:
            #Q
            if mid < answer:
                answer = mid
            right = mid-1
            
    return answer
'''
최대 1,000,000,000명 입국심사기다림
심사관 100,000
빨리 끝나는 심사대 찾기(이분탐색)

A
left: 심사걸리는 시간의 최솟값
right: 심사걸리는 시간의 최댓값
mid: 심사걸리는데 최소로 근접한 값
Sum: mid를 left, right 어디에 갱신할지의 기준이 된다. mid/time을 한 값들이 n이 되야하는 것 중 제일 최솟값을 찾아야한다.
if문: Sum <= n이 된다면 n보다 작은 경우도 포함될 수 있다. 우리는 Sum >= n 인 n보다는 큰 최소의 mid값을 찾아야한다.
작은 것중에 제일 근접한걸 찾는 경우도 있을 수 있다.
  
'''
