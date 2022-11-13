def solution(n, k):
    k_num, cnt = [], 0
    while n >= k:
        tmp = n % k
        n = n // k
        k_num.append(str(tmp))
    k_num.append(str(n))

    real_k = str(''.join(k_num[::-1]))
    find_prime = []
    find_prime = list(real_k.split("0"))
    for i in find_prime:
        if i != '':
            if is_prime(int(i)):
                cnt += 1
    return cnt

def is_prime(n):
    if n == 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True