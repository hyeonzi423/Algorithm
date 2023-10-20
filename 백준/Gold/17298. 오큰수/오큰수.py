n = int(input())
nums = list(map(int, input().split()))
answer = [-1] * n

stack = []
for i in range(n):
    while stack and nums[stack[-1]] < nums[i]:
        answer[stack.pop()] = nums[i]
    stack.append(i)
print(*answer)