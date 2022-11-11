from itertools import combinations
def solution(nums):
    answer, res = 0, []
    com = list(combinations(nums, 3))
    for i in set(com):
        res.append(sum(i))
    for j in res:
        check = True
        for i in range(2, int(j**0.5)+1):
            if j % i == 0:
                check = False
        if check == True:
            answer += 1
    return answer