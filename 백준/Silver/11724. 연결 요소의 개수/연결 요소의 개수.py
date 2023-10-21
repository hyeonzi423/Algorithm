from collections import deque
n, m= map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0]*(n+1)

def dfs(num):
    q.append(num)

    while q:
        node = q.popleft()
        for i in graph[node]:
            if not visited[i]:
                visited[i] = 1
                dfs(i)

cnt = 0
for i in range(1, n+1):
    if not visited[i]:
        visited[i] = 1
        q = deque()
        dfs(i)
        cnt += 1
print(cnt)
