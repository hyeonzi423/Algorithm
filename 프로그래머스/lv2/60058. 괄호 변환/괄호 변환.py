def solution(p):
    if not p: #1
        return ""
    
    u, v = part(p) #2
    
    if check(u): #3
        return u + solution(v) #3-1
    else: #4
        answer = '(' #4-1
        answer += solution(v) #4-2
        answer += ')' #4-3
        for i in u[1:len(u)-1]: #4-4
            answer += '(' if i == ')' else ')'
    return answer

def check(p):
    cnt = 0
    for i in range(len(p)):
        if p[i] == '(':
            cnt += 1
        else:
            if cnt > 0:
                cnt -= 1
            else:
                return False
    return True if cnt == 0 else False

def part(p):
    o, c = 0, 0
    for i in range(len(p)):
        if p[i] == '(':
            o += 1
        else:
            c += 1
        if o == c:
            return p[:i + 1], p[i + 1:]