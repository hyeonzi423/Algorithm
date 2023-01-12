N = int(input())
N_list = list(map(int, input().split()))
cnt = 0
N_list.sort()

for want in range(0, N):
    left, right = 0, N-1
    while True:
        if want == right:
            right -= 1
        if want == left:
            left += 1
        if left == right:
            break
        plus = N_list[left] + N_list[right]
        if plus == N_list[want]:
            cnt += 1
            break
        elif plus < N_list[want]:
            left += 1
        else:
            right -= 1
print(cnt)
