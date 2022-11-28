def solution(record):
    record_l, answer, uid = [], [], []
    for i in record:
        tmp = list(map(str, i.split(" ")))
        record_l.append(tmp)
        uid.append(tmp[1])

    dic_io = {user_id: [] for user_id in set(uid)}
    for r in record_l:
        if r[0] != "Leave":
            dic_io[r[1]] = r[2]
    
    for i in record_l:
        if i[0] == "Enter":
            answer.append(dic_io[i[1]] + "님이 들어왔습니다.")
        elif i[0] == "Leave":
            answer.append(dic_io[i[1]] + "님이 나갔습니다.")  
    return answer