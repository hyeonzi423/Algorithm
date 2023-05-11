def solution(targets):
    answer = 0
    targets.sort(key = lambda x:(x[1], x[0]))
    
    s, e = 0, 0
    for t in targets:
        if t[0] >= e:
            e = t[1]
            answer += 1
    return answer