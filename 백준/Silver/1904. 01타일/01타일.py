n = int(input())
if n == 1:
    print(1)
elif n == 2:
    print(2)
else:
    j = [0 for i in range(n + 1)]
    j[1], j[2] = 1, 2
    for i in range(3, n+1):
        j[i] = (j[i-1] + j[i-2]) % 15746
    print(j[n])