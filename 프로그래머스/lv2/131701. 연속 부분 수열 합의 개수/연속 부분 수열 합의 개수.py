def solution(elements):
    answer = []
    len_e = len(elements)
    elements = elements * 2
    for i in range(1, len_e + 1):
        for j in range(len_e):
            tmp = elements[j:j+i]
            answer.append(sum(tmp))
    return len(set(answer))