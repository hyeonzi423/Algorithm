import heapq
def solution(operations):
    answer = [0,0]
    h = []
    for i in range(len(operations)):
        if operations[i] == 'D 1':
            if len(h) > 0:
                h.pop()
        elif operations[i] == 'D -1':
            if len(h) > 0:
                heapq.heappop(h)
        else:
            a, b = operations[i].split()
            heapq.heappush(h, int(b))
    
    if len(h) > 0:
        answer = [max(h), min(h)]
    return answer 