n = int(input())
ans = 0
idx = 1
while 1:
    if idx > n-1:
        break
    ans += idx*n +idx
    idx += 1
print(ans)