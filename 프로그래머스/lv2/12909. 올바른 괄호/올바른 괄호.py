def solution(s):
    check = []
    check_answer = []
    for i in s:
        if i == "(":
            check.append(i)
        else:
            if len(check) == 0:
                check_answer.append(0) 
            else:
                check.pop()
    if len(check) != 0:
        check_answer.append(0)
    answer = False if 0 in check_answer else True
    return answer