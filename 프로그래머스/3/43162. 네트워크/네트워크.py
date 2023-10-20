def solution(n, computers):
    ans = 0
    
    def dfs(a):
        visited[a] = 1
        for j in range(n):
            if computers[a][j] and not visited[j]:
                dfs(j)
    
    visited = [0]*n
    for i in range(n):
        if not visited[i]:
            dfs(i)
            ans += 1  
    return ans