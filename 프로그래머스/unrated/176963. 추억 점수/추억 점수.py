def solution(name, yearning, photo):
    answer = []
    score = {}

    for n, y in zip(name, yearning):
        score[n] = y
    
    for i in range(len(photo)):
        ans = 0
        for j in range(len(photo[i])):
            if photo[i][j] in score:
                ans += score[photo[i][j]]
        answer.append(ans)
        
    return answer