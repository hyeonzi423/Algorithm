from heapq import *
def solution(scoville, K):
    answer, cnt = -1, 0
    heapify(scoville)
    while len(scoville) > 1:
        fir = heappop(scoville)
        sec = heappop(scoville)
        heappush(scoville, fir + sec*2)
        cnt += 1
        if scoville[0] >= K:
            answer = cnt
            break
    return answer 