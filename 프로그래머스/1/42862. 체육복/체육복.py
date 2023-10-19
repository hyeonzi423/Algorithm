def solution(n, lost, reserve):
    answer = n
    real_lost = list(set(lost) - set(reserve))
    real_reserve = list(set(reserve) - set(lost))
    cnt = 0
    real_lost.sort()
    for l in real_lost:
        if l-1 in real_reserve:
            real_reserve.remove(l-1)
            cnt += 1
        elif l+1 in real_reserve:
            real_reserve.remove(l+1)
            cnt += 1
    return answer - len(real_lost) + cnt