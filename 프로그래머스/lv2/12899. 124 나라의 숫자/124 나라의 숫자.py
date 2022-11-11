def solution(n):
    answer = ''
    while n > 0:
        n = n - 1
        n_r = n % 3
        if n_r == 0:
            answer += "1"
        elif n_r == 1:
            answer += "2"
        else:
            answer += "4"
        n = n//3
    return answer[::-1]