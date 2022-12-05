def solution(k, tangerine):
    num, n =  0, 0
    tanger = set(tangerine)
    t = {i: 0  for i in tanger}
    for i in tangerine:
        t[i] += 1
    cnt = [b for a, b in t.items()]
    cnt.sort(reverse = True)
    for i in cnt:
        num += i
        n += 1
        if num >= k:
            break
    return n