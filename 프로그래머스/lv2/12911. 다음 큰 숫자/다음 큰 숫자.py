def solution(n):
    n_1 = format(n, "b").count("1")
    for i in range(n + 1, 1000000):
        new = format(i, "b").count("1")
        if new == n_1:
            break
    answer = i
    return answer