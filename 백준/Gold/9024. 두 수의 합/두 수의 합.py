t = int(input())
for i in range(t):
    n, K = map(int, input().split())
    arr = sorted(list(map(int, input().split())))
    left, right, check, ans = 0, n - 1, 10**9, 0
    while True:
        if left == right:
            break
        tmp = arr[left] + arr[right]
        if tmp > K:
            right -= 1
            if abs(tmp - K) < check:
                check = abs(tmp - K)
                ans = 1
            elif abs(tmp - K) == check:
                ans += 1
        else:
            left += 1
            if abs(tmp - K) < check:
                check = abs(tmp - K)
                ans = 1
            elif abs(tmp - K) == check:
                ans += 1
    print(ans)
