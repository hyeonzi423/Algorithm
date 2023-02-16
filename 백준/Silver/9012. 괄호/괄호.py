T = int(input())
for t in range(T):
    test = [i for i in input()]
    tmp = 0
    while test:
        if test.pop() == ')':
            tmp += 1
        else:
            tmp -= 1
            if tmp < 0:
                break
    ans = 'YES' if tmp == 0 else 'NO'
    print(ans)