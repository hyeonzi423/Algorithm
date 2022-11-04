def solution(a, b, n):
    answer = 0
    while 1:
        x, y = n//a, n - n//a*a
        answer += x * b
        if x * b + y < a:
            break
        else:
            n = x * b + y
    return answer