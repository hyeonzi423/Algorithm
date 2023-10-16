from collections import deque
def solution(begin, target, words):
    answer = 0
    q = deque()
    q.append([begin, 0])
    visited = [0]*len(words)
    while q:
        now, num = q.popleft()
        if now == target:
            answer = num
            break
        for i in range(len(words)):
            cnt = 0
            if not visited[i]:
                for j in range(len(now)):
                    if now[j] != words[i][j]:
                        cnt += 1
                if cnt == 1:
                    q.append([words[i], num + 1])
                    visited[i] = 1
    return answer