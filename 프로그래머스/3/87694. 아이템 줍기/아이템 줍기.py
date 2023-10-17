from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    maps = [[-1] * 102 for _ in range(102)]
    
    for r in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, r)
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                if x1 < i < x2 and y1 < j < y2:
                    maps[i][j] = 0
                elif maps[i][j] != 0:
                    maps[i][j] = 1
                    
    dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]             
    q = deque()
    q.append([characterX*2, characterY*2])
    visited = [[1]*102 for _ in range(102)]
    
    while q:
        x, y = q.popleft()
        if x == itemX*2 and y == itemY*2:
            answer = visited[x][y] // 2
            break
        for f in range(4):
            nx, ny = x + dx[f], y + dy[f]
            if 0 <= nx < 102 and 0 <= ny < 102 and visited[nx][ny] == 1 and maps[nx][ny] == 1:
                q.append([nx, ny])
                visited[nx][ny] = visited[x][y] + 1
    
    return answer