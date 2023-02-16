import sys
T = int(sys.stdin.readline())
stack = []
for t in range(T):
    order = sys.stdin.readline().split()
    if order[0] == 'push':
        stack.append(order[1])
    elif order[0] == 'pop':
        print(stack.pop() if stack else -1)
    elif order[0] == 'size':
        print(len(stack))
    elif order[0] == 'empty':
        print(0 if stack else 1)
    else:
        print(stack[-1] if stack else -1)