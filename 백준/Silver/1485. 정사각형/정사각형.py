T = int(input())

for _ in range(T):
    point = []
    for i in range(4):
        x, y = map(int, input().split())
        point.append([x, y])

    point.sort()

    #대각선
    check1 = (point[2][1] - point[1][1])**2 + (point[2][0] - point[1][0])**2
    check2 = (point[3][1] - point[0][1])**2 + (point[3][0] - point[0][0])**2
    #길이
    length1 = (point[1][1] - point[0][1])**2 + (point[1][0] - point[0][0])**2
    length2 = (point[2][1] - point[0][1])**2 + (point[2][0] - point[0][0])**2

    if check1 == check2 and length1 == length2:
        print(1)
    else:
        print(0)