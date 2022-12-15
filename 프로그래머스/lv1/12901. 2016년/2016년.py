def solution(a, b):
    day = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']
    start = 0
    if a == 2 or a == 8:
        start == 0
    elif a == 3 or a == 11:
        start = 1
    elif a == 6:
        start = 2
    elif a == 9  or a == 12:
        start = 3
    elif a == 1 or a == 4 or a == 7:
        start = 4
    elif a == 10:
        start = 5
    elif a == 5:
        start = 6
    d = start + b % 7 - 7 if (start + b % 7) >= 7 else start + b % 7
    return day[d-1]