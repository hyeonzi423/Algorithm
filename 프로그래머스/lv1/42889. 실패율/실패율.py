def solution(N, stages):
    res = []
    num = len(stages)
    for i in range(1, N + 1):
        if stages.count(i) == 0:
            fail = 0
        else:
            fail = stages.count(i) / num
        res.append([i, fail])
        num -= stages.count(i)
    answer = sorted(res, key = lambda x: x[1], reverse=True)
    answer = [stage[0] for stage in answer]
    return answer