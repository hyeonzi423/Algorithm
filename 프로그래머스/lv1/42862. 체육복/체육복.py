def solution(n, lost, reserve):
    s = 0
    real_reserve = list(set(reserve) - set(lost))
    real_lost = list(set(lost) - set(reserve))
    real_lost.sort()
    real_reserve.sort()
    for i in real_lost:
        if i - 1 in real_reserve:
            real_reserve.remove(i - 1)
            s += 1
        elif i + 1 in real_reserve: 
            real_reserve.remove(i + 1)
            s += 1
    answer = n - len(real_lost) + s
    return answer