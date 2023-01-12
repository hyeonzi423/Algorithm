N = int(input())
M = int(input())
N_list = list(map(int, input().split()))
cnt, left, right = 0, 0, N-1

N_list.sort()

while True:
    if left == right:
        break
    plus = N_list[left] + N_list[right]
    if plus == M:
        cnt += 1
        right -= 1
    elif plus < M:
        left += 1
    else:
        right -= 1

print(cnt)