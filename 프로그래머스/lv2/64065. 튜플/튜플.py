def change(s):
    s = [i for i in s[1: len(s) - 1]]
    tmp1 = []
    
    for i in range(len(s)):
        if s[i] == "{":
            tmp2 = []
        elif s[i] in ",}":
            if len(tmp2) != 0:
                tmp1.append("".join(tmp2))
                tmp2 = []
        else:
            tmp2.append(s[i])
    return tmp1

def solution(s):
    list_s = change(s)
    set_s = set(list_s)  
    count, answer = [], []
    dic_cnt = {int(i):list_s.count(i) for i in set_s}
    dic_cnt = sorted(dic_cnt.items(), reverse = True, key = lambda item: item[1])
    for i in dic_cnt:
        answer.append(i[0])
    return answer