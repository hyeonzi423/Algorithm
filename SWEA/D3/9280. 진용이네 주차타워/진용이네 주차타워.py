t = int(input())

for i in range(t):
    ans = 0
    n, m = map(int, input().split())
    cost = []
    for j in range(n):
        cost.append(int(input()))
    weight = []
    for j in range(m):
        weight.append(int(input()))

    space = [0]*n
    wait = []
    for j in range(2*m):
        number = int(input())
        check = False
        if number > 0:
            for k in range(n):
                if space[k] == 0:
                    space[k] = number
                    ans += cost[k]*weight[number-1]
                    check = True
                    break
        else:
            for k in range(n):
                if space[k] == abs(number):
                    space[k] = 0
                    break
            check = True
            if wait:
                first = wait.pop(0)
                space[k] = first
                ans += cost[k] * weight[first - 1]
        if not check:
            wait.append(number)
    print("#" + str(i+1) + " " + str(ans))