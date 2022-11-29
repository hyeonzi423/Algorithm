a, b = map(int, input().split())
cnt = 0

while True:
    tmp = b
    if b % 2 == 0:
        b //= 2
        cnt += 1
    elif b % 10 == 1:
        b //= 10
        cnt += 1
    if b <= a or tmp == b:
        break
print(cnt + 1 if b == a else -1)