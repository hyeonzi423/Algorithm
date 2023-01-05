def solution(i, j, k):
    answer = 0
    for n in range(i, j+1):
        tmp = [t for t in str(n)]
        for m in tmp:
            if int(m) == k:
                answer += 1
    return answer