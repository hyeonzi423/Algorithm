import heapq
import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    start, end, cost = map(int, (sys.stdin.readline().split()))
    graph[start].append([cost, end])

want_start, want_end = map(int, (sys.stdin.readline().split()))
queue = [(0, want_start)]
dis = [sys.maxsize] * (n + 1)
dis[want_start] = 0

while queue:
    new_cost, node = heapq.heappop(queue)
    if new_cost > dis[node]:
        continue
    for next_cost, next_node in graph[node]:
        if dis[next_node] > new_cost + next_cost:
            dis[next_node] = new_cost + next_cost
            heapq.heappush(queue, (new_cost + next_cost, next_node))
print(dis[want_end])

