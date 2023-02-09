num = []
while True:
    n = int(input())
    if n == 0:
        break
    num.append(n)
m_num = max(num)

prime = [1 for _ in range(2 * m_num + 1)]
prime[0], prime[1] = 0, 0
for i in range(2, int((2 * m_num)**0.5) + 1):
    for j in range(2, (2 * m_num)//i + 1):
        prime[i*j] = 0

for i in num:
    tmp = prime[i + 1: 2 * i + 1]
    cnt = 0
    for p in tmp:
        if p == 1:
            cnt += 1
    print(cnt)