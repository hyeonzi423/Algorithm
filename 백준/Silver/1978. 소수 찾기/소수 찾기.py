n = int(input())
n_l = input().split()
cnt = 0

def is_prime(n):
    if n == 1:
        return 0
    for p in range(2, int(n ** 0.5)+1):
        if n % p == 0:
            return 0
    return 1

for i in n_l:
    if is_prime(int(i)) == 1:
        cnt += 1
print(cnt)