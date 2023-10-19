def solution(sizes):
    max_x, max_y = 0, 0
    for x, y in sizes:
        if x > y:
            x, y = y, x
        max_x = max(max_x,x)
        max_y = max(max_y,y)
    return max_x*max_y