def solution(num):
    answer = 0
    if num == 1:
        return 0
    else:
        while True:
            if num % 2 == 0:
                num /= 2
            else:
                num = num*3 + 1
            answer += 1
            if num == 1:
                break
            elif answer == 500:
                answer = -1
                break
        return answer