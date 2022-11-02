def solution(phone_number):
    n = len(phone_number)-4
    answer = "*"*n + phone_number[-4:]
    return answer