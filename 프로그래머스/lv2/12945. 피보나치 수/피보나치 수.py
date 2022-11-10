def solution(n):
    f0, f1 = 0, 1
    for i in range(2, n+1):
        f_n = (f0 + f1) % 1234567
        f0 = f1
        f1 = f_n
    return f_n