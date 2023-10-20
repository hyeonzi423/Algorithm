def solution(number, k):
    answer = []
    for i in range(len(number)):
        while k > 0 and answer and int(answer[-1]) < int(number[i]):
            answer.pop()
            k -= 1
        answer.append(number[i])
    return ''.join(answer[:len(number)-k])