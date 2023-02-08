N = int(input())
is_prime = [1 for _ in range(N + 1)]
is_prime[0], is_prime[1] = 0, 0

for i in range(2, int(N ** 0.5) + 1):
    if is_prime[i]:
        for j in range(2, N // i + 1):
            is_prime[i * j] = 0

prime = []
for i in range(2, N + 1):
    if is_prime[i]:
        prime.append(i)

left, right, hap, ans = 0, 0, 0, 0
while 1:
    if hap >= N:
        if hap == N:
            ans += 1
        hap -= prime[left]
        left += 1
    elif right == len(prime):
        break
    else:
        hap += prime[right]
        right += 1
print(ans)
