def solution(prices):
    res = []
    for i in range(len(prices)-1):
        tmp = prices[i]
        cnt = 0
        for j in range(i+1, len(prices)):
            cnt += 1
            if tmp > prices[j]:
                break
        res.append(cnt)
    res.append(0)
    return res