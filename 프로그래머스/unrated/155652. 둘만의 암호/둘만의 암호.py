def solution(s, skip, index):
    answer = ''
    s = [i for i in s]
    for i in s:
        tmp = []
        while len(tmp) < index:
            a = ord(i)- ord('z') + ord('a') if ord(i) + 1 > ord('z') else ord(i) + 1
            if chr(a) not in skip:
                tmp.append(a)
            i = chr(a)
        answer += chr(tmp[-1])
    return answer