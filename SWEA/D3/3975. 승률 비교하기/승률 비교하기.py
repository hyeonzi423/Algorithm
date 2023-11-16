t = int(input())
ans = []
for i in range(t):
    a, b, c, d = map(int, input().split())
    s1, s2 = a/b, c/d
    if s1 == s2:
        ans.append("DRAW")
    elif s1 > s2:
        ans.append("ALICE")
    else:
        ans.append("BOB")

for j in range(len(ans)):
    print("#" + str(j+1) + " " + ans[j])