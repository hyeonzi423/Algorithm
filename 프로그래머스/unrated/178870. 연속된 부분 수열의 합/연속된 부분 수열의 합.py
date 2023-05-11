def solution(sequence, k):
    answer = []
    l, r, res = 0, 0, sequence[0]
    if res == k:
        answer.append([l, r])
    
    while True:
        if res < k:
            r += 1
            if r >= len(sequence):
                break
            res += sequence[r]
        else:
            l += 1
            if l >= len(sequence):
                break
            res -= sequence[l - 1]
        if res == k:
            answer.append([l, r])
    answer.sort(key=lambda x: (x[1] - x[0], x[0]))
    return answer[0]