def solution(n, words):
    check = [words[0]]
    answer = [0, 0]
    for i in range(1, len(words)):
        if words[i] not in check and check[-1][-1] == words[i][0]:
            check.append(words[i])
        else:
            answer = [i % n + 1,i // n + 1]
            break
    return answer