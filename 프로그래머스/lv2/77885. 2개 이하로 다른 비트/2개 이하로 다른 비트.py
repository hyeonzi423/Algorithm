def solution(numbers):
    answer = []
    for i in numbers:
        if i % 2 == 0:
            answer.append(i+1)
        else:
            tmp = bin(i)[2:]
            if '0' in tmp:
                for i in range(len(tmp)-1, -1, -1):
                    if tmp[i] == '0':
                        break
                tmp = tmp[:i] + '1' + '0' + tmp[i+2:]
                answer.append(int(tmp, 2))
            else:
                tmp = "1" + "0" + tmp[1:]
                answer.append(int(tmp, 2))
    return answer