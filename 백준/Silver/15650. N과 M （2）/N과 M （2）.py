n, m = map(int, input().split())
s = []

def f(i):
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    for i in range(i+1, n+1):
        if i in s:
            continue
        s.append(i)
        f(i)
        s.pop()
f(0)