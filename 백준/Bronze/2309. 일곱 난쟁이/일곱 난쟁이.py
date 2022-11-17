import sys
short, check = [], True
for i in range(9):
    short.append(sys.stdin.readline())

for i in range(9):
    for j in range(i + 1, 9):
        s = [int(short[z]) for z in range(9) if z != i and z != j]
        if sum(s) == 100:
            check = False
            break
    if check == False:
        break
        
s.sort()
for i in s:
    print(i)