t = int(input())
res = []

for i in range(t):
    n, k = map(int, input().split())
    dp = [[0] * (k+1) for _ in range(n+1)]
    thing = [list(map(int, input().split())) for _ in range(n)]

    for i in range(1, n+1):
        v, c = thing[i-1]
        for j in range(1, k+1):
            if j >= v:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-v]+c)
            else:
                dp[i][j] = dp[i-1][j]

    res.append(dp[-1][-1])
    
for i in range(t):
    print("#" + str(i+1) + " " + str(res[i]))