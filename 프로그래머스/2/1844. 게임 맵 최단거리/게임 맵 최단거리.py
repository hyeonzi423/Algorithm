from collections import deque
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[0] * m for _ in range(n)]
    dis = [[0] * m for _ in range(n)]
    dq = deque()
    dq.append([0, 0])
    visited[0][0] = 1
    dis[0][0] = 1

    while dq:
        x, y = dq.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and maps[nx][ny] == 1:
                visited[nx][ny] = 1
                dis[nx][ny] = dis[x][y] + 1
                dq.append([nx, ny])

    ans = dis[n-1][m-1] if dis[n-1][m-1] != 0 else -1
    return ans

