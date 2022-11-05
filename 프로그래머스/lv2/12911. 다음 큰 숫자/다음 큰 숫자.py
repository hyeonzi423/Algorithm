def solution(n):
    n_1 = (bin(n)[2:]).count("1")
    
    for i in range(n + 1, 1000000):
        new = (bin(i)[2:]).count("1")
        if new == n_1:
            break
    answer = i
    return answer