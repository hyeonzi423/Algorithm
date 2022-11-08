def solution(s):
    check = []
    answer = True
    for i in s:
        if i == "(":
            check.append(i)
        else:
            if len(check) == 0:
                answer = False
                break
            else:
                check.pop()
    if len(check) != 0:
        answer = False
    return answer