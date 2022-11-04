def solution(arr):
    arr.remove(min(arr))
    answer = [-1] if len(arr) == 0 else arr
    return answer