from collections import deque
def solution(maps):
    dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
    q = deque()
    q.append([0, 0])
    visited = [[1]*len(maps[0]) for _ in range(len(maps))]
    while q:
        x, y = q.popleft()
        for f in range(4):
            nx, ny = x + dx[f], y + dy[f]
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and visited[nx][ny] == 1 and maps[nx][ny] == 1:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx, ny])
    answer = visited[-1][-1] if visited[-1][-1] != 1 else -1                
    return answer
