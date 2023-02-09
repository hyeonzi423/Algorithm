n = int(input())
seat = [i for i in input()]

cup, left, right, L = 0, True, True, 0
for i in range(n):
    if seat[i] == 'S':
        if left:
            cup += 1
        elif right:
            left = False
            cup += 1
    else:
        if L == 0:
            if left:
                cup += 1
            L += 1
        else:
            if right:
                cup += 1
                left = False
            L = 0
print(cup)