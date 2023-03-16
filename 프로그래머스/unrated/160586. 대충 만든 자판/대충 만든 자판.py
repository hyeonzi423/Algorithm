def solution(keymap, targets):
    answer = []
    for i in range(len(keymap)):
        keymap[i] = [keymap[i][j] for j in range(len(keymap[i]))]
    
    for i in range(len(targets)):
        cnt = 0
        for j in range(len(targets[i])):
            tmp, min_value = targets[i][j], 100
            for k in range (len(keymap)):
                if tmp in keymap[k]:
                    if min_value > keymap[k].index(tmp):
                        min_value = keymap[k].index(tmp) + 1
            if min_value == 100:
                cnt = -1
                break
            cnt += min_value 
        answer.append(cnt)
    return answer