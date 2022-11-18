import heapq
import sys

V, E = map(int, (sys.stdin.readline().split()))
graph = [[] for _ in range(V+1)]
visited = [False for _ in range(V+1)]

for _ in range(E):
    A, B, C = map(int, (sys.stdin.readline().split()))
    graph[A].append([B, C])
    graph[B].append([A, C])

res = 0
queue = []
queue.append([0, 1])

while queue:
    c_c, c_n = heapq.heappop(queue)
    if visited[c_n] == False:
        visited[c_n] = True
        res += c_c
        for n_n, n_c in graph[c_n]:
            heapq.heappush(queue, (n_c, n_n))
print(res)
