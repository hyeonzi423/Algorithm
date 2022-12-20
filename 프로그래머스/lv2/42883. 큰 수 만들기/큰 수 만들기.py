def solution(number, k):
    answer = [] 
    for num in number:
        while k > 0 and answer and answer[-1] < num:
            k -= 1
            answer.pop()
        answer.append(num)
    return ''.join(answer[:len(answer) - k])