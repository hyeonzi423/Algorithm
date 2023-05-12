def solution(genres, plays):
    answer = []
    music = {i: [] for i in set(genres)}
    music_cnt = {i: 0 for i in set(genres)}
    
    for i in range(len(genres)):
        music[genres[i]].append([plays[i], i])
        music_cnt[genres[i]] += plays[i]
        
    d_sort = dict(sorted(music_cnt.items(), key = lambda x: x[1], reverse = True))
    
    for i in d_sort:
        tmp = music[i]
        tmp.sort(key = lambda x:(-x[0], x[1]))
        for j in tmp[:2]:
            answer.append(j[1])
    return answer