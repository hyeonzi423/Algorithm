def solution(dots):
    answer = 0
    for i in range(4):
        for j in range(i+1, 4):
            slide1 = (dots[j][1] - dots[i][1]) / (dots[j][0] - dots[i][0])
            remain = [0,1,2,3]
            remain.remove(i)
            remain.remove(j)
            slide2 = (dots[remain[1]][1] - dots[remain[0]][1]) / (dots[remain[1]][0] - dots[remain[0]][0])
            if slide1 == slide2:
                return 1
    return 0