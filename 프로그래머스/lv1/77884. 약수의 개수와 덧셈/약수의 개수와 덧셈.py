def solution(left, right):
    answer = 0
    for i in range(left, right + 1):
        if is_prime(i) %2 == 0:
            answer+= i
        else:
            answer -= i
    return answer

def is_prime(n):
    cnt = 0
    for i in range(1, int(n**0.5) + 1):
        if n % i == 0:
            cnt += 1
    total = cnt*2 + 1 if int(n**0.5) * int(n**0.5) == n else cnt*2
    return total

        
        
        