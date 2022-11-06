def solution(arr):
    answer = []
    for i in range(len(arr)):
        if i == 0 or i - 1 >= 0 and answer[len(answer)-1] != arr[i]:
            answer.append(arr[i])
    return answer