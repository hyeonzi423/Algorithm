def solution(pri, loc):
    answer = 0
    pro = []
    for i, p in enumerate(pri):
        pro.append([p, i])

    while pro:
        now = pro.pop(0)
        check = True
        for i in range(len(pro)):
            if now[0] < pro[i][0]:
                check = False
        if check:
            answer += 1
            if now[1] == loc:
                return answer
        else:
            pro.append(now)