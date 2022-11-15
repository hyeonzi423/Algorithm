def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        tmp = []
        for j in range(len(arr2[0])):
            s = 0
            for k in range(len(arr2)):
                s += arr1[i][k] * arr2[k][j]
            tmp.append(s)
        answer.append(tmp)
    return answer