import string
def convert(n, k) :
    number = '0123456789ABCDEF'
    jinsu = ''
    while n >= k:
        n, r = n//k, n%k
        jinsu += number[r]
    jinsu += number[n]
    return jinsu[::-1] 

def solution(n, t, m, p):
    num, answer = '0', ''
    tmp = 1
    while True:
        if len(num) >= t*m:
            break
        else:
            num += convert(tmp, n)
        tmp += 1
    for i in range(len(num)):
        if i % m + 1 == p :
            answer += num[i]
    return answer[:t]