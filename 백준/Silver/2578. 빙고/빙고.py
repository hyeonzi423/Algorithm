graph = [list(map(int, input().split())) for _ in range(5)]
num = []
for _ in range(5):
    tmp = list(map(int, input().split()))
    for r in tmp:
        num.append(r)

def find_n(a):
    for i in range(5):
        for j in range(5):
            if graph[i][j] == a:
                graph[i][j] = 0

def bingo_check():
    cnt = 0
    for i in range(5):
        if set(graph[i]) == {0}:
            cnt += 1

    for i in range(5):
        tmp = [graph[0][i], graph[1][i], graph[2][i], graph[3][i], graph[4][i]]
        if set(tmp) == {0}:
            cnt += 1

    tmp1, tmp2 = [], []
    for i in range(5):
        tmp1.append(graph[i][i])
        tmp2.append(graph[i][4-i])
    if set(tmp1) == {0}:
        cnt += 1
    if set(tmp2) == {0}:
        cnt += 1
    return cnt


for i, n in enumerate(num):
    if i < 5:
        find_n(num[i])
    else:
        find_n(num[i])
        if bingo_check() >= 3:
            print(i+1)
            break
