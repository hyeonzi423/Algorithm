from itertools import permutations
def solution(numbers):
    perm, tmp, answer = [], [], 0
    num = [i for i in numbers]
    for i in range(1, len(num) + 1):
        perm += list(permutations(num, i))
    for i in range(len(perm)):
        tmp.append(int(''.join(perm[i])))
    
    for i in set(tmp):
        cnt = 0
        for j in range(1, i + 1):
            if i % j == 0:
                cnt += 1
            if cnt > 2:
                break
        if cnt == 2:
            answer += 1
    return answer