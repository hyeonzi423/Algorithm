def solution(triangle):
    for i in range(1, len(triangle)):
        triangle[i][0] += triangle[i-1][0]
        triangle[i][-1] += triangle[i-1][-1]
        for j in range(1, i):
            if triangle[i-1][j-1] < triangle[i-1][j]: 
                triangle[i][j] += triangle[i-1][j]
            else:
                triangle[i][j] += triangle[i-1][j-1]
    return max(triangle[-1])