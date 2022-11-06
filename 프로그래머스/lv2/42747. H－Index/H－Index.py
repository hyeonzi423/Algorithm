def solution(citations):
    tmp = []
    citations.sort(reverse = True)
    for i in range(len(citations) + 1):
        num1 = [a for a in citations if a >= i]
        num2 = [b for b in citations if b <= i]
        print(len(num1), i, len(citations) - len(num1), len(num2))
        if len(num1) >= i and len(num2) <= i:
            tmp.append(i)
    answer = max(tmp) if len(tmp) != 0 else 0
    return answer