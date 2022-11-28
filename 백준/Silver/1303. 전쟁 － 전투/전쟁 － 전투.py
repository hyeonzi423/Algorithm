from collections import deque

n, m = map(int, input().split())
graph, blue, white = [], 0, 0
for i in range(m):
    graph.append(list(input()))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(a, b, color):
    queue = deque()
    queue.append((a, b))
    graph[a][b] = 0
    count = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            elif graph[nx][ny] == color:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                count += 1
    return count


for i in range(m):
    for j in range(n):
        if graph[i][j] == "B":
            blue += bfs(i, j, graph[i][j]) ** 2
        elif graph[i][j] == "W":
            white += bfs(i, j, graph[i][j]) ** 2

print(white, blue)