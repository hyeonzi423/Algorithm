from itertools import permutations
def solution(n):
    f1, f2 = 1, 1
    if n < 2:
        return 1
    for i in range(n-1):
        f3 = (f1 + f2) % 1234567
        f1, f2 = f2, f3
    return f3