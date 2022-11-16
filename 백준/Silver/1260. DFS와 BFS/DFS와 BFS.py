from collections import deque
def bfs(graph, start_node):
  visited = []
  queue = deque([start_node])

  while queue:
    node = queue.popleft()
    if node not in visited:
      visited.append(node)
      queue.extend(graph[node])

  return visited

def dfs(graph, start_node):
  visited = []
  stack = [start_node]

  while stack:
    node = stack.pop()
    if node not in visited:
      visited.append(node)
      stack.extend(reversed(graph[node]))

  return visited

n, m, v = map(int, input().split())

graph = {i:[] for i in range(1,n+1)}
for i in range(1, m+1):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for key in graph:
    graph[key].sort()

print(' '.join(list(map(str,dfs(graph, v)))))
print(' '.join(list(map(str,bfs(graph, v)))))