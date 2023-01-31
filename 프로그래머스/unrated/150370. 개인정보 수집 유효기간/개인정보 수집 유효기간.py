def solution(today, terms, privacies):
    answer = []
    y, m, d = map(int, today.split("."))
    today = int(today.replace(".", ""))
    term = [i.split() for i in (terms)]
    
    for i in range(len(privacies)):
        date, doc = privacies[i].split()
        d_y, d_m, d_d = map(int, date.split("."))
        for alpha, num in term:
            if alpha != doc:
                continue;
            else:
                res = ''
                end_y = d_y
                end_m = d_m + int(num)
                end_d = d_d - 1
                
                if end_d < 1:
                    end_d = 28
                    end_m -= 1
                    if end_m < 1:
                        end_m = 12
                        end_y -= 1
                
                if end_m > 12:
                    if end_m % 12 != 0:
                        end_y += end_m // 12
                        end_m = end_m % 12 
                    else:
                        end_y += end_m // 12 - 1
                        end_m = 12
            
                res += str(end_y)
                res += str(end_m).zfill(2)
                res += str(end_d).zfill(2)
                print(res)
                if int(res) < today:
                    answer.append(i+1)
    return answer