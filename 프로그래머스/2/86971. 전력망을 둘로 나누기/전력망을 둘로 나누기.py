from collections import deque
def solution(n, wires):
    graph = [[] for _ in range(n+1)]
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    def bfs(node):
        cnt = 1
        q = deque()
        q.append(node)
        visited = [0] * (n + 1)
        visited[node] = 1
        
        while q:
            now = q.popleft()
            if len(graph[now]) > 0:
                for x in graph[now]:
                    if not visited[x]:
                        visited[x] = 1
                        q.append(x)
                        cnt += 1
        return cnt
    
    answer = n
    for a, b in wires:
        graph[a].remove(b)
        graph[b].remove(a)

        answer = min(answer, abs(bfs(a) - bfs(b)))
        
        graph[a].append(b)
        graph[b].append(a)
        
    return answer