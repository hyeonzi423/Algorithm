n = int(input())
right, part_sum, cnt = 0, 0, 0

for left in range(1, n+1):
    while part_sum < n:
        part_sum += right
        right += 1
    if part_sum == n:
        cnt += 1
    part_sum -= left

print(cnt)