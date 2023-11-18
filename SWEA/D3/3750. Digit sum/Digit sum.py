t = int(input())
res = []

for i in range(t):
    num = str(input())
    while 1:
        if len(num) == 1:
            res.append(num)
            break
        else:
            hap = 0
            for j in range(len(num)):
                hap += int(num[j])
            num = str(hap)

for i in range(t):
    print("#" + str(i+1) + " " + str(res[i]))