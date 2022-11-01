def solution(numbers):
    ori = [0,1,2,3,4,5,6,7,8,9]
    sub = set(ori) - set(numbers)
    return sum(sub)