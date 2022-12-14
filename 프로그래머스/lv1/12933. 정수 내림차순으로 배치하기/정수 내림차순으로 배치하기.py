def solution(n):
    answer = ''
    num = [int(i) for i in str(n)]
    num.sort(reverse = True)
    num = [str(i) for i in num]
    answer = ''.join(num)
    return int(answer)