from itertools import permutations
def solution(k, dungeons):
    init_k = k
    answer = -1
    for i in list(permutations(dungeons, len(dungeons))):
        tmp = i
        cnt = 0
        k = init_k
        for t in tmp:
            if k >= t[0]:
                k -= t[1]
                cnt += 1
            else:
                break
        
        if cnt == len(dungeons):
            answer = cnt
            break
        answer = max(answer, cnt)
    return answer