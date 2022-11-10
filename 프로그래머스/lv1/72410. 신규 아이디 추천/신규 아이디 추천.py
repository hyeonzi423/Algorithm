def solution(new_id):
    fir = new_id.lower()
    
    sec = ""
    for i in fir:
        if i.isalnum() or i in '._-':
            sec += i
            
    thr = sec
    while ".." in thr:
        thr = thr.replace("..", ".")
    
    four = thr[1:] if thr[0] == "." else thr
    
    fiv = four if len(four) != 0  else "a"
    
    six = fiv[:15]
    if len(six) >= 15:
        six = six if six[-1] != "." else six[:14]
    else:
        six = six if six[-1] != "." else six[:len(six)-1]
    
    seven = six
    if len(seven) <= 2:
        seven = seven + seven[-1]*(3-len(seven))

    return seven