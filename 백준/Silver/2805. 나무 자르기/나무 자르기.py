import sys
n, m = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

trees.sort()
low, high = 0, sum(trees)

while low <= high:
    mid = (high + low)//2
    cut = sum([i - mid for i in trees if i > mid])
    if cut >= m:
        low = mid + 1
    else:
        high = mid - 1

print(high)