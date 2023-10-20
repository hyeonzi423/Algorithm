from itertools import combinations
n = int(input())
num = [i + 1 for i in range(n)]
graph = [list(map(int, input().split())) for _ in range(n)]
answer = 1000000

teams = list(combinations(num, n//2))
cnt = 0
for team in teams:
    cnt += 1
    t1, t2 = 0, 0
    for x in team:
        for y in team:
            t1 += graph[x-1][y-1]
    not_team = [i+1 for i in range(n) if i+1 not in team]
    for x in not_team:
        for y in not_team:
            t2 += graph[x-1][y-1]
    answer = min(answer, abs(t1-t2))
    if cnt >= len(teams) // 2:
        break
print(answer)