def solution(progresses, speeds):
    answer = []
    day = []
    for p, s in zip(progresses, speeds):
        d = (100-p) // s if (100-p) % s == 0 else (100-p) // s + 1
        day.append(d)
    print(day)
    
    cnt, check = 1, 0 
    tmp = []
    while len(day) > 1:
        now = day.pop(0)
        check = max(now, check)
        if check < day[0]:
            answer.append(cnt)
            cnt = 1
        else:
            cnt += 1
    answer.append(cnt)
    return answer