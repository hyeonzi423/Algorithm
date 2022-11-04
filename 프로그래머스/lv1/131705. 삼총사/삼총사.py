import itertools

def solution(number):
    answer = 0
    tmp = list(itertools.combinations(number,3))
    print(tmp)
    for i in tmp:
        if sum(i) == 0:
            answer += 1
    return answer