from collections import deque
def solution(queue1, queue2):
    answer = 0
    check = (sum(queue1) + sum(queue2)) // 2
    q1_hap = sum(queue1)
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    while queue1 and queue2:
        if q1_hap < check:
            q1_hap += queue2[0]
            queue1.append(queue2.popleft())
            answer += 1
        elif q1_hap > check:
            q1_hap -= queue1.popleft()
            answer += 1
        else:
            return answer
        
    return -1