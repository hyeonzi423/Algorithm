from heapq import *
def solution(scoville, K):
    answer = 0
    heapify(scoville)
    if scoville[0] >= K:
        return 0
    while len(scoville) > 1:
        f = heappop(scoville)
        s = heappop(scoville)
        heappush(scoville, f+s*2)
        answer += 1
        if scoville[0] >= K:
            break
    if scoville[0] < K:
        answer = -1
    return answer