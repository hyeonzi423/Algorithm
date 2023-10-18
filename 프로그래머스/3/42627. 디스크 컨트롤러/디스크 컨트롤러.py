import heapq
def solution(jobs):
    answer = 0
    con = []
    heapq.heapify(con)
    r, now, cnt = -1, 0, 0
    
    while cnt < len(jobs):
        for s, t in jobs:
            if r < s <= now:
                heapq.heappush(con, [t, s])
        if len(con) > 0:
            a, b = heapq.heappop(con)
            r = now
            now += a
            answer += now - b
            cnt += 1
        else:
            now += 1
    return answer//(len(jobs))