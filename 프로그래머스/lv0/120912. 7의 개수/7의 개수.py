def solution(array):
    n = 0
    for i in str(array):
        for j in str(i):
            if j == '7':
                n += 1
    return n