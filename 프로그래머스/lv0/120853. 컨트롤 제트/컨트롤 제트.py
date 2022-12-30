def solution(s):
    total = 0
    s_l = s.split()
    for i in range(len(s_l)):
        if s_l[i] != 'Z':
            total += int(s_l[i])
        else:
            total -= int(s_l[i-1])
    return total