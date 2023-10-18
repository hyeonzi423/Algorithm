import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    cnt = 0
    while 1:
        if scoville[0] >= K:
            return cnt
        if len(scoville) == 1:
            return -1
        else:
            s1 = heapq.heappop(scoville)
            s2 = heapq.heappop(scoville)
            heapq.heappush(scoville, s1 + s2*2)
            cnt += 1