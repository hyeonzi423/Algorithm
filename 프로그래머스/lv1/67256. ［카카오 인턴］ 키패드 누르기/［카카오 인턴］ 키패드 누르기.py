def solution(numbers, hand):
    answer = ''
    left, right = 10, 12
    for i in numbers:
        if str(i) in '147':
            answer += 'L'
            left = i
        elif str(i) in '369':
            answer += "R"
            right = i
        else:
            if i == 0:
                i = 11
            l, r, i = left-1,  right-1, i-1
            l_dis = abs(l//3 - i//3) + abs(l%3 - i%3)
            r_dis = abs(r//3 - i//3) + abs(r%3 - i%3)
            i = 11 if i == 10 else i+1
            if l_dis == r_dis:
                if hand == "right":
                    answer += "R"
                    right = i
                else:
                    answer += 'L'
                    left = i
            elif l_dis > r_dis:
                answer += "R"
                right = i
            else:
                answer += 'L'
                left = i
    return answer