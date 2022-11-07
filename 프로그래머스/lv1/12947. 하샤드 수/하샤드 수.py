def solution(x):
    answer = True if x % sum(list(map(int, [i for i in str(x)]))) == 0 else False
    return answer