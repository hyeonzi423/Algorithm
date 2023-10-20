n = int(input())
stairs = [int(input()) for _ in range(n)]

if n == 1:
    answer = stairs[0]
elif n == 2:
    answer = stairs[0] + stairs[1]

else:
    dp = [0] * (n+1)
    dp[0] = stairs[0]
    dp[1] = stairs[0] + stairs[1]
    dp[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2])

    for i in range(3, n):
        dp[i] = max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i])
    answer = dp[n-1]
print(answer)