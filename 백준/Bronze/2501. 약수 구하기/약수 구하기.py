import sys
n, k = map(int, sys.stdin.readline().split())
tmp = [1]
for i in range(2, n + 1):
    if n % i == 0:
        tmp.append(i)
answer = tmp[k - 1] if len(tmp) >= k else 0
print(answer)