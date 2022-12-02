def solution(prices):
    res = []
    for i in range(len(prices)-1): # 맨 마지막은 어차피 0 이기 때문에 길이 -1 까지만 반복
        tmp = prices[i]
        cnt = 0
        for j in range(i+1, len(prices)):
            cnt += 1 # tmp 바로 다음 수가 작아도 1초는 유지했다고 표현하기 때문에 cnt를 먼저 올림
            if tmp > prices[j]: # 현재 tmp보다 큰 수를 찾으면 break 
                break
        res.append(cnt)
    res.append(0) # 맨 마지막에 0 추가
    return res