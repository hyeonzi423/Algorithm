n = int(input())
value = sorted(list(map(int, input().split())))
check = 3 * 10 ** 9

for i in range(n-1):
    left = i + 1
    right = n - 1
    while left < right:
        tmp = value[i] + value[left] + value[right]
        if abs(tmp) < check:
            check = abs(tmp)
            res = [value[i], value[left], value[right]]
        if tmp > 0:
            right -= 1
        elif tmp < 0:
            left += 1
        else:
            break
for i in res:
    print(i, end=' ')
