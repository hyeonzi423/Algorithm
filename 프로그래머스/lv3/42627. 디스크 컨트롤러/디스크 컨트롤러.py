import heapq
def solution(jobs):
    heap, answer = [], 0
    request, now, i = -1, 0, 0
    while i < len(jobs):
        for job in jobs:
            if request < job[0] <= now:
                heapq.heappush(heap, [job[1], job[0]])
        if len(heap) > 0:
            tmp = heapq.heappop(heap)
            request = now
            now += tmp[0]
            answer += now - tmp[1]
            i += 1
        else:
            now += 1
    return answer//(len(jobs))