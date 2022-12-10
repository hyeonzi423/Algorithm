def solution(s):
    answer = [-1]
    for i in range(1, len(s)):
        tmp = s[:i]
        if s[i] not in tmp:
            answer.append(-1)
        else:
            tmp = tmp[::-1]
            for j in range(len(tmp)):
                if tmp[j] == s[i]:
                    answer.append(j+1)
                    break           
    return answer