def solution(prices):
    answer = []
    for i in range(len(prices) - 1):
        now = prices[i]
        cnt = 1
        for j in range(i+1, len(prices)):
            if now > prices[j] or j == len(prices) - 1:
                answer.append(cnt)
                break
            else:
                cnt += 1
    answer.append(0)
    return answer