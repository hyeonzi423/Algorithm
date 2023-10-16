def solution(tickets):
    answer = []
    con = dict()
    for start, end in tickets:
        if start in con:
            con[start].append(end)
        else:
            con[start] = [end]
    
    for c in con.keys():
        con[c].sort(reverse = True)
    stack = ['ICN']
    while len(stack) != 0:
        top = stack[-1]
        if top not in con or not con[top]:
            answer.append(stack.pop())
        else:
            stack.append(con[top].pop())
            print(con)
    return answer[::-1]