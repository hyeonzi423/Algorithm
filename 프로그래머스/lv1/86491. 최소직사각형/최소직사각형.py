def solution(sizes):
    width, length = [], []
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            sizes[i][0], sizes[i][1] = sizes[i][1], sizes[i][0] 
        width.append(sizes[i][0])
        length.append(sizes[i][1])
        
    answer = max(width) * max(length)
    return answer