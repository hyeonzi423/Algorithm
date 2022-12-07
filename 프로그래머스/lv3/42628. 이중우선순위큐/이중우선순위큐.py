import heapq
def solution(operations):
    answer = []
    for i in operations:
        if i == 'D 1':
            if len(answer) != 0:
                answer.pop()
        elif i == 'D -1':
            if len(answer) != 0:
                heapq.heappop(answer)             
        else:
            alpha, num = i.split()
            heapq.heappush(answer, int(num))
    if len(answer) == 0: 
        return [0,0]
    else:
        return [max(answer), min(answer)]
