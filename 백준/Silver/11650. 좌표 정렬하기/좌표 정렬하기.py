import sys
n = int(sys.stdin.readline())
point = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    point.append((a, b))

point.sort(key=lambda x: (x[0], x[1]))

for a, b in point:
    print(a, b)