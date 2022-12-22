def solution(quiz):
    answer = []
    for i in quiz:
        tmp = i.split(" ")
        if tmp[1] == '+':
            if int(tmp[0]) + int(tmp[2]) == int(tmp[-1]):
                answer.append("O")
            else:
                answer.append("X")
        else:
            if int(tmp[0]) - int(tmp[2]) == int(tmp[-1]):
                answer.append("O")
            else:
                answer.append("X")
    return answer