from collections import deque
def solution(begin, target, words):
    answer = 0
    q = deque()
    q.append([begin, 0])
    visited = [0] * len(words)
    
    while q:
        b, c = q.popleft()
        if b == target:
            answer = c
            break
        for i in range(len(words)):
            cnt = 0
            for j in range(len(words[0])):
                if not visited[i]:
                    if b[j] != words[i][j]:
                        cnt += 1
            if cnt == 1:
                visited[i] = 1
                q.append([words[i], c+1])       
    return answer