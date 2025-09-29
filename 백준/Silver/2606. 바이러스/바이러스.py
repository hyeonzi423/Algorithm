n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

def dfs(start):
    global cnt
    visited[start] = True
    cnt += 1
    for node in graph[start]:
        if not visited[node]:
            dfs(node)

cnt = 0
visited = [0 for _ in range(n+1)]
dfs(1)
print(cnt-1)