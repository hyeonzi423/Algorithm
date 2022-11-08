def solution(n):
    n_prime = [n]
    answer = 0
    for i in range(1, int(n**1/2) + 1):
        if n % i == 0:
            n_prime.append(i)
                
    for j in range(len(n_prime)):
        if n_prime[j] % 2 != 0:
            answer += 1
    return answer