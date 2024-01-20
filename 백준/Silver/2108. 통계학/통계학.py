import sys
input = sys.stdin.readline

num = int(input())
nums = []
for _ in range(num):
    nums.append(int(input()))

nums.sort()
tmp = sum(nums)/num
print(int(sum(nums)/num + 0.5) if tmp > 0 else int(sum(nums)/num - 0.5))
print(nums[int(num/2)])

if num == 1:
    print(nums[0])
else:
    check = {}
    for i in nums:
        if i in check:
            check[i] += 1
        else:
            check[i] = 1
    check2 = sorted(check.items(), key=lambda x:(-x[1], check.items()))
    print(check2[1][0] if check2[0][1] == check2[1][1] else check2[0][0])
print(nums[-1] - nums[0])
