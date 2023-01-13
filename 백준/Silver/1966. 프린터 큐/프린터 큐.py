import sys
n = int(sys.stdin.readline())
cnt = 0

for i in range(n):
    cnt = 0
    size, want = map(int, sys.stdin.readline().split())
    priority = list(map(int, sys.stdin.readline().split()))
    while True:
        if priority[0] != max(priority):
            priority.append(priority.pop(0))
            want = len(priority) - 1 if want == 0 else want - 1
        else:
            priority.pop(0)
            cnt += 1
            if want == 0:
                print(cnt)
                break
            else:
                want -= 1