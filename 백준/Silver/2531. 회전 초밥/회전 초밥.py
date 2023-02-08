dish, sushi, k, coupon = map(int, input().split())
belt = [int(input()) for i in range(dish)]
for i in range(k - 1):
    belt.append(belt[i])

ans = 0
for i in range(dish):
    tmp = belt[i: i+k]
    if coupon not in tmp:
        tmp.append(coupon)
    l_tmp = len(set(tmp))
    if ans < l_tmp:
        ans = l_tmp
print(ans)