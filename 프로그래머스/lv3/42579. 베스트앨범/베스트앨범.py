def solution(genres, plays):
    answer = []
    g = {i: [] for i in set(genres)}
    g_n = {i: 0 for i in set(genres)}
    
    for i in range(len(plays)):
        g[genres[i]].append([i, plays[i]])
        g_n[genres[i]] += plays[i]
        
    g_n = sorted(g_n.items(), key=lambda x: x [1], reverse = True)

    for a, b in g_n:
        tmp = g[a]
        tmp.sort(key = lambda x: (-x[1], x[0]))
        for i in tmp[:2]:
            answer.append(i[0])
    return answer