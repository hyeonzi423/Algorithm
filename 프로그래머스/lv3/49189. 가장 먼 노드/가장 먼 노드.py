from collections import deque

def solution(n, edge):
    def bfs(a):
        q = deque()
        visited[a] = 1
        for i in graph[a]:
            q.append(i)
            visited[i] = 2
        while q:
            x = q.popleft()
            for k in graph[x]:
                if not visited[k]:
                    q.append(k)
                    visited[k] = visited[x] + 1

    graph = [[] for _ in range(n+1)]
    visited = [0 for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)

    bfs(1)
    
    v, cnt = max(visited), 0
    for i in range(1, n+1):
        if v == visited[i]:
            cnt += 1
    return cnt