import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

def dfs(x, y, n, m):
    visited[x][y] = True
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= nx < m) and (0 <= ny < n):
            if not visited[nx][ny] and matrix[nx][ny]:
                dfs(nx, ny, n, m)

while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    matrix = [list(map(int, input().split())) for _ in range(m)]
    visited = [[False] * n for _ in range(m)]

    ans = 0
    for i in range(m):  # 세로
        for j in range(n):  # 가로
            if not visited[i][j] and matrix[i][j]:
                ans += 1
                dfs(i, j, n, m)
    print(ans)