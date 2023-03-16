def solution(cards1, cards2, goal):
    answer = "Yes"
    for i in range (len(goal) - 1):
        if goal[i] in cards1:
            idx = cards1.index(goal[i])
            if goal[i+1] in cards1:
                if len(cards1)-1 < idx+1:
                    answer = "No"
                else:
                    if goal[i+1] != cards1[idx+1]:
                        answer = "No"
        elif goal[i] in cards2:
            idx = cards2.index(goal[i])
            if goal[i+1] in cards2:
                if len(cards2)-1 < idx+1:
                    answer = "No"
                else:
                    if goal[i+1] != cards2[idx+1]:
                        answer = "No"
    return answer