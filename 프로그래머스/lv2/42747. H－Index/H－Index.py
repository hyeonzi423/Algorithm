def solution(citations):
    answer = 0
    for i in range(len(citations) + 1):
        num1 = [a for a in citations if a >= i]
        num2 = [b for b in citations if b <= i]
        if len(num1) >= i and len(num2) <= i:
            answer = i
    return answer