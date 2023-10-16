from collections import deque
def solution(n, computers):
    ans = 0
    
    def bfs(i):
        q = deque()
        q.append(i)
        visited[i] = 1
        while q:
            node = q.popleft()
            for c in range(n):
                if computers[node][c] and not visited[c]:
                    q.append(c)
                    visited[c] = 1
            
    visited = [0]*n
    for f in range(n):
        if not visited[f]:
            bfs(f)
            ans += 1
        
    return ans