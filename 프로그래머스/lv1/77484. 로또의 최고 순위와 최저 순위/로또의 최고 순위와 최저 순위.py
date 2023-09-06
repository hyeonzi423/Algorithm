def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    hit, zero = 0, 0
    for i in range(6):
        if lottos[i] != 0:
            if lottos[i] in win_nums:
                hit += 1
        else:
            zero += 1
    return [rank[hit+zero], rank[hit]]