n = int(input())
value = sorted(list(map(int, input().split())))
x = int(input())
left, right, ans = 0, n - 1, 0

while left < right:
    tmp = value[left] + value[right]
    if tmp >= x:
        if tmp == x:
            ans += 1
        right -= 1
    else:
        left += 1
print(ans)