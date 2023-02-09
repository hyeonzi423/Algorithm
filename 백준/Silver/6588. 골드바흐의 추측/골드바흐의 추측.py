num = []
while True:
    n = int(input())
    if n == 0:
        break
    num.append(n)
m_num = max(num)

prime = [1 for _ in range(m_num + 1)]
prime[0], prime[1] = 0, 0
for i in range(2, int(m_num ** 0.5) + 1):
    for j in range(2, m_num//i + 1):
        prime[i*j] = 0
prime[2] = 0

for n in num:
    for i in range(3, int(n/2) + 1):
        if prime[i] and prime[n-i]:
            print(n, "=", i, "+", n-i)
            break