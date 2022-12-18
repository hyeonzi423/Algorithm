def solution(babbling):
    answer = 0
    can = ["aya", "ye", "woo", "ma"]
    res = []
    
    for i in range(len(babbling)):
        for j in range(4):
            if can[j] + can[j] in babbling[i]:
                continue
            if can[j] in babbling[i]:
                babbling[i] = babbling[i].replace(can[j], str(j))
        res.append(babbling[i])
    
    for i in res:
        if i.isdigit():
            answer += 1
    return answer