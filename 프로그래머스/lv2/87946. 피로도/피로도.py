from itertools import permutations

def solution(k, dungeons):
    init_k, res = k, []
    dict_dungeons = dict(dungeons)
    dungeons = [i[0] for i in dungeons]
    perm = list(set(permutations(dungeons, len(dungeons))))
    
    for i in range(len(perm)):
        k, game = init_k, 0
        for j in range(len(perm[0])): 
            if k >= perm[i][j]:
                k = k - dict_dungeons[perm[i][j]]
                game += 1
        res.append(game)
        if game == len(dungeons):
            break
    
    answer = max(res) if len(res) != 0 else 0
    return answer