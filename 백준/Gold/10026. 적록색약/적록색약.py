import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())
matrix = [list(input().rstrip()) for _ in range(n)]
visited = [[False] * n for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
    visited[x][y] = True
    now_color = matrix[x][y]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= nx < n) and (0 <= ny < n):
            if not visited[nx][ny]:
                if matrix[nx][ny] == now_color:
                    dfs(nx, ny)

rgb_cnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            rgb_cnt += 1

for i in range(n):
    for j in range(n):
        if matrix[i][j] == 'G':
            matrix[i][j] = 'R'

rb_cnt = 0
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            rb_cnt += 1

print(rgb_cnt, rb_cnt)