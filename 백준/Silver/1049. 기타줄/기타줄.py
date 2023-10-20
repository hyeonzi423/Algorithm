n, m = map(int, input().split())
six, one = [], []
for _ in range(m):
    s, o = map(int, input().split())
    six.append(s)
    one.append(o)

six.sort()
one.sort()

a = n // 6
r = n % 6
if six[0]/6 < one[0]:
    print(int(min((a+1)*six[0], a*six[0] + r*one[0])))
else:
    print(n*one[0])