n = int(input())
value = list(map(int, input().split()))
left, right = 0, n - 1
check, res1, res2 = abs(value[left] + value[right]), value[left], value[right]

while left < right:
    tmp = value[left] + value[right]
    if abs(tmp) < check:
        check = abs(tmp)
        res1 = value[left]
        res2 = value[right]
        if check == 0:
            break
    if tmp > 0:
        right -= 1
    else:
        left += 1
print(res1, res2)