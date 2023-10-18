def solution(genres, plays):
    answer = []
    music = {i: [] for i in set(genres)}
    num = {i: 0 for i in set(genres)}
    
    for i in range(len(genres)):
        music[genres[i]].append([plays[i], i])
        num[genres[i]] += plays[i]
    
    num = sorted(num.items(), key = lambda x: x[1], reverse = True)
    
    for g, p in num:
        tmp = music[g]
        tmp.sort(key = lambda x:(-x[0], x[1]))
        for i in tmp[:2]:
            answer.append(i[1])
    return answer