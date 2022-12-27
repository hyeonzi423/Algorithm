def solution(chicken):
    answer = 0
    while True:
        get, r = divmod(chicken, 10)
        answer += get
        chicken = get + r
        if chicken < 10:
            break
    return answer