def solution(t, p):
    answer = 0
    p_l = len(p)
    int_p = int(p)
    for i in range(len(t) + 1 - p_l):
        if int(t[i: i + p_l]) <= int_p:
            answer += 1
    return answer