def solution(dirs):
    x, y, res = 0, 0, []
    nx, ny = 0, 0
    for i in dirs:
        if i == 'U' and ny < 5:
            ny += 1
        elif i == 'D' and ny > -5:
            ny -= 1
        elif i == 'R' and nx < 5:
            nx += 1
        elif i == 'L' and nx > -5:
            nx -= 1
        if x != nx or y != ny:    
            if (x, y, nx, ny) not in res:
                if (nx, ny, x, y) not in res:                
                    res.append((x, y, nx, ny))
        x, y = nx, ny
    return len(res)