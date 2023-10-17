def solution(s):
    answer = True
    check = 0
    for i in range(len(s)):
        if s[i] == '(':
            check += 1
        else:
            if check < 1:
                return False
            else:
                check -= 1
    return True if check == 0 else False