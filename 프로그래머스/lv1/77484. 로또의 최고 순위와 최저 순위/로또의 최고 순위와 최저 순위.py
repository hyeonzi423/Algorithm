def solution(lottos, win_nums):
    h = [i for i in lottos if i in win_nums]
    hit = len(h)
    zero = lottos.count(0)
    best = hit + zero if hit + zero <= 6 else 6
    best = best if best != 0 else 1
    worst = hit if hit >= 2 else 1 
    return [6 - best + 1 , 6 - worst + 1]