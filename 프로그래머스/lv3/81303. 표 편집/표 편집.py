def solution(n, k, cmd):
    linked_list = {i: [i - 1, i + 1] for i in range(n)}
    answer = ["O"] * n
    remove = []
    
    for i in cmd:
        order = i.split()
        if order[0] == 'D':
            for _ in range(int(order[1])):
                k = linked_list[k][1]
        elif order[0] == 'U':
            for _ in range(int(order[1])):
                k = linked_list[k][0]
        elif order[0] == 'C':
            pre, nxt = linked_list[k]
            answer[k] = 'X'
            remove.append((pre, k, nxt))
            
            if nxt == n:
                k = linked_list[k][0]
            else:
                k = linked_list[k][1]
            
            if pre == -1:
                linked_list[nxt][0] = pre
            elif nxt == n:
                linked_list[pre][1] = nxt
            else:
                linked_list[pre][1] = nxt
                linked_list[nxt][0] = pre
        else:
            pre, now, nxt = remove.pop()
            answer[now] = "O"
            
            if pre == -1:
                linked_list[nxt][0] = now
            elif nxt == n:
                linked_list[pre][1] = now
            else:
                linked_list[pre][1] = now
                linked_list[nxt][0] = now
                
    return ''.join(answer)