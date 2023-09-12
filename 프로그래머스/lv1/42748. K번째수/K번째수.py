def solution(array, commands):
    answer = []
    for s, e, l in commands:
        tmp = array[s-1: e]
        tmp.sort()
        answer.append(tmp[l-1])
    return answer