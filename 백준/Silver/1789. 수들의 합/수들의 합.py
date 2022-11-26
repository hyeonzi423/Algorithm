n = int(input())
i = 0
while True:
    if n - i <= 0:
        break
    n -= i
    i += 1
print(i - 1 if n != i else i)