def solution(msg):
    answer = []
    alpha = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
             "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
    n, i = 0, 0
    while i != len(msg):
        i += 1
        if msg[n:i+1] not in alpha:
            alpha.append(str(msg[n:i+1]))
            answer.append(alpha.index(str(msg[n:i])) + 1)
            n = i
    answer.append(alpha.index(str(msg[n:i])) + 1)
    return answer