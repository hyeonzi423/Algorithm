from collections import deque

def solution(n, results):
    answer = 0
    win = [[] for _ in range(n+1)]
    lose = [[] for _ in range(n+1)]
    visited = [0 for _ in range(n+1)]
    for a, b in results:
        win[a].append(b)
        lose[b].append(a)
    
    for i in range(1, n+1):
        visited = [0 for _ in range(n+1)]
        visited[0] = True
        visited[i] = True
        for nodes in [win, lose]:
            q = deque([i])
            while q:
                index = q.popleft()
                for node in nodes[index]:
                    if not visited[node]:
                        visited[node] = 1
                        q.append(node)
        if 0 not in visited:
            answer += 1
    return answer