def solution(s):
    answer = True
    n = 0
    for i in range(len(s)):
        if s[i] == '(':
            n += 1
        else:
            if n < 1:
                return False
            else:
                n -= 1
    if n != 0:
        return False
    return True