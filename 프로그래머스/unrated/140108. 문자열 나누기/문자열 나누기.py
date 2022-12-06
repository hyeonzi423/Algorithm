def solution(s):
    s = [i for i in s]
    tmp1 = s.pop(0)
    answer, a, b = 0, 1, 0
    while s:
        if a != b:
            tmp2 = s.pop(0)
            if tmp1 == tmp2:
                a += 1
            else:
                b += 1
        else:
            tmp1 = s.pop(0)
            a, b = 1, 0
            answer += 1
    return answer + 1