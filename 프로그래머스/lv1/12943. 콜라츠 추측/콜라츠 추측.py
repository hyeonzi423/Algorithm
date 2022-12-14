def solution(num):
    answer = 0
    if num == 1:
        return 0
    else:
        while True:
            num =  num / 2 if num % 2 == 0 else num*3 + 1
            answer += 1
            if num == 1:
                break
            elif answer == 500:
                answer = -1
                break
        return answer