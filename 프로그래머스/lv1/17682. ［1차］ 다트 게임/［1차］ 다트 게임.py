def solution(dartResult):
    res, tmp = [], ''
    for i in range(len(dartResult)):
        if dartResult[i] not in "SDT*#":
            tmp += dartResult[i]
        else:
            if dartResult[i] == "S":
                res.append(int(tmp))
            elif dartResult[i] == "D":
                res.append(int(tmp)**2)
            elif dartResult[i] == "T":
                res.append(int(tmp)**3)
            elif dartResult[i] == "*":
                if len(res) >= 2:
                    res[-2] = res[-2]*2
                res[-1] = res[-1]*2
            elif dartResult[i] == "#":
                res[-1] = res[-1]*(-1)
            tmp = '' 
    return sum(res)