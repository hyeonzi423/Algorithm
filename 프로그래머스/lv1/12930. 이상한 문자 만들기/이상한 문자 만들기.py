def solution(s):
    answer = ""
    tmp =  list(map(str, s.split(" ")))
    for i in range(len(tmp)):
        for j in range(len(tmp[i])):
            if j % 2 == 0:
                answer += str(tmp[i][j].upper())
            else:
                answer += str(tmp[i][j].lower())
        if i < len(tmp) - 1:
            answer += " "
    return answer