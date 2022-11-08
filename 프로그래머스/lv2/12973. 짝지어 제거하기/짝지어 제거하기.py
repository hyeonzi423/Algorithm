def solution(s):
    check = []
    check.append(s[0])
    for i in range(1, len(s)):
        if len(check) != 0 and check[-1] == s[i]:
            check.pop()
        else:
            check.append(s[i])
    answer = 1 if len(check)==0 else 0      
    return answer
