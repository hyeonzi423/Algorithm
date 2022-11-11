def solution(arr1, arr2):
    answer = []
    for a, b in zip(arr1, arr2):
        tmp = []
        for i in range(len(a)):
            x = a[i] + b[i]
            tmp.append(x)
        answer.append(tmp)
    return answer