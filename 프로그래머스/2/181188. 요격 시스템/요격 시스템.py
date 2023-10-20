def solution(targets):
    targets.sort(key = lambda x:x[1])
    
    answer = 0
    point = 0
    for a, b in targets:
        if not a < point < b:
            point = b - 0.5
            answer += 1
        else:
            continue
    return answer