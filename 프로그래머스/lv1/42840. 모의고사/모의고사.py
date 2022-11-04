def copy_s(n, m):
    num = 1 if n / m < 1 else int(n / m)
    return num


def solution(answers):
    answer = []
    c_1, c_2, c_3 = 0, 0, 0 
    s_1 = [1,2,3,4,5] * int(10000/5)
    s_2 = [2,1,2,3,2,4,2,5] * int(10000/8)
    s_3 = [3,3,1,1,2,2,4,4,5,5] * int(10000/10)
    
    # s_1_answers = s_1 * copy_s(len(answers), 5)
    # s_2_answers = s_2 * copy_s(len(answers), 8)
    # s_3_answers = s_3 * copy_s(len(answers), 10)

    for i in range(len(answers)):
        if answers[i] == s_1[i]:
            c_1 += 1
        if answers[i] == s_2[i]:
            c_2 += 1
        if answers[i] == s_3[i]:
            c_3 += 1
    
    max_s = max(c_1, c_2, c_3)
    if max_s == c_1:
        answer.append(1)
    if max_s == c_2:
        answer.append(2)
    if max_s == c_3:
        answer.append(3)
    
    return answer