from itertools import product

def solution(word):
    tmp = []
    for i in range(1, 6):
        for j in product('AEIOU', repeat=i):
            tmp.append(''.join(j))
    tmp.sort()
    answer = tmp.index(word) + 1
    return answer
