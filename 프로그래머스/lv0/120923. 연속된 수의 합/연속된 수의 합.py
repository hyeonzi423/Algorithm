def solution(num, total):
    answer = []
    tmp = total // num
    if num % 2 == 0:
        tmp -= num // 2 - 1
        for i in range(num):
            answer.append(tmp)
            tmp += 1
    else:
        tmp -= num // 2
        for i in range(num):
            answer.append(tmp)
            tmp += 1
    return answer