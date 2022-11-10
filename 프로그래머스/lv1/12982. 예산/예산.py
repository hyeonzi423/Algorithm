def solution(d, budget):
    d.sort()
    s, i = 0, 0
    for i in range(len(d)):
        s += d[i]
        if s > budget:
            i = i - 1
            break
        elif s == budget:
            break
    answer = i + 1
    return answer