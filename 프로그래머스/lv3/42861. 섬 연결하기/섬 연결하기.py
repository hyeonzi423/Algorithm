def solution(n, costs):
    answer = 0
    costs.sort(key = lambda x: x[2])
    cycle = set([costs[0][0]])
    
    while len(cycle) < n:
        for f, t, c in costs:
            if f in cycle and t in cycle:
                continue
            elif f in cycle or t in cycle:
                cycle.add(f)
                cycle.add(t)
                answer += c
                break
    return answer