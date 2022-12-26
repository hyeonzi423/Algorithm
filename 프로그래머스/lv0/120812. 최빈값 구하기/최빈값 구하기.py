from collections import Counter
def solution(array):
    tmp = Counter(array).most_common()
    if len(tmp) > 1 and tmp[0][1] == tmp[1][1]:
        return -1
    else:
        return tmp[0][0]