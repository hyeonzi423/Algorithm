def solution(X, Y):
    answer = ''
    n1 = [0,0,0,0,0,0,0,0,0,0]
    n2 = [0,0,0,0,0,0,0,0,0,0]
    
    for i in X:
        n1[int(i)] += 1
    for i in Y:
        n2[int(i)] += 1
        
    for i in range(9,-1, -1):
        n = n1[i] if n1[i] < n2[i] else n2[i]
        if i == 0:
            if len(answer) == 0 and n1[i]!= 0 and n2[i]!= 0:
                n = 1
        answer += str(i)*n
    
    if len(answer) == 0:
        return "-1"
    else: 
        return answer