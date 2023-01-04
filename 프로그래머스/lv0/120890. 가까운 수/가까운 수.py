def solution(array, n):
    answer, tmp = 0, 101
    for i in array:
        if tmp > abs(i - n):
            tmp = abs(i - n)
            answer = i
        elif tmp == abs(i - n):
            answer = answer if answer < i else i
    return answer