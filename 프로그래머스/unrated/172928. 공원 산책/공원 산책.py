def solution(park, routes):
    graph = []
    for i in range(len(park)):
        tmp = []
        for j in range(len(park[i])):
            tmp.append(park[i][j])
            if park[i][j] == 'S':
                start = [i, j]
        graph.append(tmp)

    n, m = len(graph), len(graph[0])
    for r in routes:
        d, k = r.split()
        k, check = int(k), True
        if d == 'E':
            next_j = start[1]
            if next_j + k >= m:
                continue
            for _ in range(k):
                next_j += 1
                if graph[start[0]][next_j] == 'X':
                    check = False
                    break
            if check == True:
                start = [start[0], next_j]
        elif d == 'W':
            next_j = start[1]
            if next_j - k < 0:
                continue
            for _ in range(k):
                next_j -= 1
                if graph[start[0]][next_j] == 'X':
                    check = False
                    break
            if check == True:
                start = [start[0], next_j]
        elif d == 'N':
            next_i = start[0]
            if next_i - k < 0:
                continue
            for _ in range(k):
                next_i -= 1
                if graph[next_i][start[1]] == 'X':
                    check = False
                    break
            if check == True:
                start = [next_i, start[1]]
        elif d == 'S':
            next_i = start[0]
            if next_i + k >= n:
                continue
            for _ in range(k):
                next_i += 1
                if graph[next_i][start[1]] == 'X':
                    check = False
                    break
            if check == True:
                start = [next_i, start[1]]
    return start