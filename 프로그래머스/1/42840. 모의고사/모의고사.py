def solution(answers):
    answer = []
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    r1, r2, r3 = len(answers)//len(p1)+1, len(answers)//len(p2)+1, len(answers)//len(p3)+1
    p1, p2, p3 = p1 * r1, p2 * r2, p3 * r3
    
    def check(a):
        cnt = 0
        for i in range(len(answers)):
            if answers[i] == a[i]:
                cnt += 1
        return cnt
    
    n1, n2, n3 = check(p1), check(p2), check(p3)
    max_x = max(n1, n2, n3)
    if n1 == max_x:
        answer.append(1)
    if n2 == max_x:
        answer.append(2)
    if n3 == max_x:
        answer.append(3)
    return answer