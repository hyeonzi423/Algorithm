from itertools import permutations
def solution(numbers):
    answer = 0
    num = [i for i in numbers]
    nums = []
    for i in range(1, len(num)+1):
        tmp = set(list(permutations(num, i)))
        for i in tmp:
            nums.append(int(''.join(i)))
    
    for i in set(nums):
        c = True
        if i > 1:
            for j in range(2, i):
                if i%j == 0:
                    c = False
                    break
            if c ==True:
                answer += 1
    return answer