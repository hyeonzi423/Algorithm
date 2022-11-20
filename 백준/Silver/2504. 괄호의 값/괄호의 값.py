import sys

s = str(sys.stdin.readline())
score, answer = 0, 1
check = []

for i in range(len(s)):
    if s[i] == "(":
        check.append(s[i])
        answer *= 2

    elif s[i] == "[":
        check.append(s[i])
        answer *= 3

    elif s[i] == ")":
        if len(check) == 0 or check[-1] != "(":
            break
        elif s[i-1] == "(":
            score += answer
        answer //= 2
        check.pop()

    elif s[i] == "]":
        if len(check) == 0 or check[-1] != "[":
            break
        elif s[i-1] == "[":
            score += answer
        answer //= 3
        check.pop()

score = score if len(check) == 0 and i == len(s) - 1 else 0
print(score)