def prime(num):
    n = 1
    if num == 1:
        return 1
    elif num / int(num**0.5) != num**0.5:
        for i in range(2, int(num**0.5+1)):
            if num % i == 0:
                n += 1
        return n*2
    else:
        for i in range(2, int(num**0.5)):
            if num % i == 0:
                n += 1
        return n*2 + 1

def solution(number, limit, power):
    answer = 0
    prime_num = [prime(i) for i in range(1, number+1)]
    for i in range(len(prime_num)):
        if prime_num[i] > limit:
            answer += power
        else:
            answer += prime_num[i]
    return answer