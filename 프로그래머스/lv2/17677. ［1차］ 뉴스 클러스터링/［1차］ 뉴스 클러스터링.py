def part(s):
    s_l = []
    for i in range(len(s) - 1):
        if (s[i] + s[i+1]).isalpha():
            s_l.append(s[i] + s[i+1])
    return s_l

def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    new_str1 = part(str1)
    new_str2 = part(str2)
    
    hap = list(set(new_str1) & set(new_str2))
    gyo = list(set(new_str1) | set(new_str2))
    
    hap_num = sum([min(new_str1.count(i),new_str2.count(i)) for i in hap])
    gyo_num = sum([max(new_str1.count(i),new_str2.count(i)) for i in gyo])
    
    if gyo_num == 0:
        return 1 * 65536
    else:
        return int(hap_num / gyo_num * 65536) 