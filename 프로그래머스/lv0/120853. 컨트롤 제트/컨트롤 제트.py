def solution(s):
    answer, total = [], 0
    s_l = s.split()
    for i in range(len(s_l)-1):
        if s_l[i+1] != "Z" and s_l[i] != "Z" :
            answer.append(s_l[i])
    if s_l[-1] != 'Z':
        answer.append(s_l[-1])
    for i in answer:
        total += int(i)
    return total