def solution(s, n):
    answer = ""
    s_list = [i for i in s]
    for i in range(len(s_list)):
        if s_list[i] == ' ':
            answer += str(" ")
        else:
            tmp = ord(s_list[i]) + n
            if tmp > 122 and s_list[i].islower():
                tmp = tmp - (ord("z") - ord("a") + 1)
            elif tmp > 90 and s_list[i].isupper():
                tmp = tmp - (ord("Z") - ord("A") + 1)
            answer += str(chr(tmp))
    return answer