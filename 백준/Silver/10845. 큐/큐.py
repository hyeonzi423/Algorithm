import sys
n = int(sys.stdin.readline())
queue = []

for i in range(n):
    tmp = list(sys.stdin.readline().split())
    if tmp[0] == 'push':
        queue.append(int(tmp[1]))
    elif tmp[0] == 'pop':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.pop(0))
    elif tmp[0] == 'size':
        print(len(queue))
    elif tmp[0] == 'empty':
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    elif tmp[0] == 'front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    else:
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])