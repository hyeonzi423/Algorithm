def solution(k, m, score):
    answer, box, tmp = 0, [], []
    score.sort()
    while score:
        tmp.append(score.pop())
        if len(tmp) == m:
            box.append(tmp)
            tmp = []
    for i in box:
        answer += i[-1] * m
    return answer