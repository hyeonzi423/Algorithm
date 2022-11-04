def solution(n):
    answer = (n**0.5 + 1)**2 if n**0.5 % int(n**0.5) == 0.0 else -1
    return answer