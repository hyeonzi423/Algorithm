def solution(clothes):
    answer = 1
    cd = dict()
    for a, b in clothes:
        if b in cd:
            cd[b].append(a)
        else:
            cd[b] = [a]
    
    for a, b in cd.items():
        answer *= (1+len(b))
    return answer - 1
        