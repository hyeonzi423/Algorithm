def solution(x):
    answer = x % sum(list(map(int, [i for i in str(x)]))) == 0
    return answer