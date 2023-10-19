def solution(n, costs):
    answer = 0
    costs.sort(key = lambda x:x[2])
    con = set([costs[0][0]])
    
    while len(con) != n:
        for s, e, c in costs:
            if s in con and e in con:
                continue
            elif s in con or e in con:
                con.add(s)
                con.add(e)
                answer += c
                break
    return answer