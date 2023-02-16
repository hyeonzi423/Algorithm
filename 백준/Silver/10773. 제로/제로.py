import sys
T = int(sys.stdin.readline())
stack = []
for t in range(T):
    num = int(sys.stdin.readline())
    if num != 0:
        stack.append(num)
    else:
        stack.pop()
print(sum(stack))