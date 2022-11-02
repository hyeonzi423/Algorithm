def solution(s):
    answer = ""
    tmp = list(map(str, s.split(" ")))
    for i in range(len(tmp)):
        if tmp[i] == '':
            answer += str(" ")
        else:
            answer += str(tmp[i][:1].upper() + tmp[i][1:].lower() + " ")
    answer = answer[:len(answer)-1]
    return answer