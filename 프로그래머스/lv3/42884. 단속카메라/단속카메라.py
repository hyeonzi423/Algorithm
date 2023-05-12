def solution(routes):
    answer = 0
    routes.sort(key = lambda x:(x[1], x[0]))
    print(routes)
    end = -30001
    for r in routes:
        if r[0] > end:
            end = r[1]
            answer += 1
    return answer