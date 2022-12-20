def solution(genres, plays):
    answer = []
    d = {g:0 for g in set(genres)}
    d_idx = {g:[] for g in set(genres)}
    
    for i in range(len(genres)):
        d[genres[i]] += plays[i]
        d_idx[genres[i]].append((i, plays[i]))
    
    d_sort = dict(sorted(d.items(), key = lambda x: x[1], reverse = True))
    
    for i in d_sort:
        tmp = d_idx[i]
        tmp.sort(key = lambda x: (x[1], -x[0]), reverse = True)
        for j in tmp[:2]:
            answer.append(j[0])
    return answer