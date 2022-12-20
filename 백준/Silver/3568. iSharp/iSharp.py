s = input().split()
for i in range(1, len(s)):
    print(s[0], end='')
    for j in range(len(s[i])-2, -1, -1):
        if not s[i][j].isalpha():
            if s[i][j] == "]":
                print('[', end='')
            elif s[i][j] == "[":
                print("]", end='')
            else:
                print(s[i][j], end='')
        else:
            break
    print(' ' + s[i][:j+1] + ";")
