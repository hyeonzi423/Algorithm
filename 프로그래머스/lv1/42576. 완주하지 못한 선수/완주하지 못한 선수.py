def solution(participant, completion):   
    participant.sort()
    completion.sort()
    answer = True
    for a, b in zip(participant, completion):
        if a != b:
            answer = a
            break
        elif answer == True:
            answer = participant[-1]
    return answer