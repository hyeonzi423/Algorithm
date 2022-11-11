def solution(progresses, speeds):
    r_days, res = [], []
    for p, s in zip(progresses, speeds):
        day = (100 - p) // s if (100 - p) % s == 0 else (100 - p) // s + 1 
        r_days.append(day)

    tmp_1 = r_days.pop(0)
    cnt = 1
    while len(r_days) > 0:
        tmp_2 = r_days.pop(0)
        if tmp_2 > tmp_1:
            res.append(cnt)
            tmp_1 = tmp_2
            cnt = 1
        else:
            cnt += 1
    if len(r_days) == 0:
        res.append(cnt)
    return res 