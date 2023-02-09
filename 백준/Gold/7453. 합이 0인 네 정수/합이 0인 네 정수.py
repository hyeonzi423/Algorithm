n = int(input())
A, B, C, D = [], [], [], []
for _ in range(n):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

ab = dict()
for a in A:
    for b in B:
        ab[a+b] = ab.get(a+b, 0) + 1

cnt = 0
for c in C:
    for d in D:
        cnt += ab.get(-(c+d), 0)

print(cnt)