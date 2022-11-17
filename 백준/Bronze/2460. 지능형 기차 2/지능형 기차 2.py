import sys
total, max_total = 0, 0
for i in range(10):
    x, y = map(int, (sys.stdin.readline().split()))
    total = total - x + y
    if max_total < total:
        max_total = total
print(max_total)