from collections import Counter
def solution(want, number, discount):
    cnt = 0
    want_dict = {a: b for a, b in zip(want, number)}
    for i in range(len(discount)-9):
        if want_dict == Counter(discount[i:i+10]):
            cnt += 1
    return cnt