from collections import deque
def solution(maps):
    dy = [0, 0, 1, -1]
    dx = [1, -1, 0, 0]
    n, m = len(maps), len(maps[0])
    
    def bfs(graph, x, y):
        queue = deque()
        queue.append((x, y))
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx >= 0 and nx < n and ny >= 0 and ny < m and graph[nx][ny]!=0:
                    if graph[nx][ny] == 1:
                        graph[nx][ny] = graph[x][y] + 1
                        queue.append((nx, ny))
        return graph[n-1][m-1]
    
    answer = bfs(maps, 0, 0)
    answer = -1 if answer == 1 else answer
    return answer