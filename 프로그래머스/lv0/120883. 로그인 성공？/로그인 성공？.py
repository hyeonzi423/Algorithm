def solution(id_pw, db):
    answer = []
    for i in range(len(db)):
        if db[i] == id_pw:
            answer.append(1)
            break
        elif db[i][0] == id_pw[0] and db[i][1] != id_pw[1]:
            answer.append(2)
        else:
            answer.append(3)
    
    if 1 in answer:
        return 'login'
    elif 2 in answer:
        return 'wrong pw'
    else:
        return 'fail'