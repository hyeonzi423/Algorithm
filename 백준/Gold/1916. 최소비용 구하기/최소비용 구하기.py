import heapq
import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    s, e, c = map(int, (sys.stdin.readline().split()))
    graph[s].append([c, e])

wx, wy = map(int, (sys.stdin.readline().split()))
q = [(0, wx)]
dis = [sys.maxsize] * (n + 1)
dis[wx] = 0

while q:
    cost, node = heapq.heappop(q)
    if cost > dis[node]:
        continue
    for nc, nn in graph[node]:
        if dis[nn] > cost + nc:
            dis[nn] = cost + nc
            heapq.heappush(q, (cost + nc, nn))
print(dis[wy])