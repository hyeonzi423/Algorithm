def solution(progresses, speeds):
    answer = []
    complete = []
    for a, b in zip(progresses, speeds):
        day = (100-a)//b if (100-a)%b == 0 else (100-a)//b + 1 
        complete.append(day)
    
    num = 1
    t1 = complete.pop(0)
    while complete:
        t2 = complete.pop(0)
        if t2 <= t1:
            num += 1
        else:
            answer.append(num)
            num = 1
            t1 = t2
    answer.append(num)
    return answer