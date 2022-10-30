def solution(s):
    if s.isdigit() and (len(s) == 4 or len(s) == 6):
        answer = True
    else:
        answer = False
    return answer