def solution(numbers, target):
    cnt = 0
    list_n =  [0]
    for n in numbers:
        tmp = []
        for l in list_n:
            tmp.append(l + n)
            tmp.append(l - n)
        list_n = tmp
    return list_n.count(target)
        