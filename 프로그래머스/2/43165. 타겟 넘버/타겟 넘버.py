def solution(numbers, target):
    list_n = [0]
    for i in numbers:
        tmp = []
        for j in list_n:
            tmp.append(j+i)
            tmp.append(j-i)
        list_n = tmp
    return list_n.count(target)