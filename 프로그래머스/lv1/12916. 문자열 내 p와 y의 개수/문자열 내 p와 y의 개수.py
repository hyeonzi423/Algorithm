def solution(s):
    p_n, y_n = 0, 0
    s_list = [i for i in s]
    for i in s_list:
        if i == "p" or i == "P":
            p_n += 1
        elif i == "y" or i == "Y":
            y_n += 1
    return p_n == y_n