n, m = map(int, input().split())
book = list(map(int, input().split()))

plus, minus = [], []
for i in book:
    if i < 0:
        minus.append(i)
    else:
        plus.append(i)

plus.sort(reverse=True)
minus.sort()

ans, far = 0, 0
for i in range(0, len(plus), m):
    ans += 2 * plus[i]
    if far < plus[i]:
        far = plus[i]

for i in range(0, len(minus), m):
    ans += 2 * abs(minus[i])
    if far < abs(minus[i]):
        far = abs(minus[i])

ans -= far
print(ans)