from itertools import permutations
def solution(k, dungeons):
    answer = -1
    init_k = k
    dict_dungeons = dict(dungeons)
    dungeons = [a for a, b in dungeons]
    
    for route in list(set(permutations(dungeons, len(dungeons)))):
        k, c, cnt = init_k, True, 0
        for r in route:
            if k >= r:
                k -= dict_dungeons[r]
                cnt += 1
            else:
                c = False
                break
        answer = max(answer, cnt)
    return answer