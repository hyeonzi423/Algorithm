def solution(n):
    change = ''
    answer = 0
    while n:
        change += str(n%3)
        n = n // 3
    for i in range(len(change)):
        answer += int(change[i]) * (3**(len(change)-1-i))
    return answer