n, k = map(int, input().split())
cnt = 0
prime = [1 for _ in range(n + 1)]
prime[0], prime[1] = 0, 0
for i in range(2, n + 1):
    for j in range(1, n//i + 1):
        if prime[i*j] == 0:
            continue
        prime[i*j] = 0
        cnt += 1
        if cnt == k:
            print(i*j)
            break