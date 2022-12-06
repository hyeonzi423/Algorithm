def solution(id_list, report, k):
    dict_user = {i:[] for i in id_list} # id별 신고한 id 저장
    report_user = {i:0 for i in id_list}
    stop_user, answer = [], []    
    
    for r in report:
        name1, name2 = r.split()
        if name2 not in dict_user[name1]:
            dict_user[name1].append(name2)
            report_user[name2] += 1
            
    for a,b in report_user.items():
        if b >= k:
            stop_user.append(a)
            
    for a, b in dict_user.items():
        cnt = 0
        for i in b:
            if i in stop_user:
                cnt += 1
        answer.append(cnt)
    return answer