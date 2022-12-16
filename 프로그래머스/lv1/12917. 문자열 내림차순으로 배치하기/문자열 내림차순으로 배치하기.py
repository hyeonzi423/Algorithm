def solution(s):
    res = [i for i in s]
    res.sort(reverse = True)
    answer = ''.join(res)
    return answer