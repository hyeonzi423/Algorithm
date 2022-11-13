from collections import deque
def solution(food):
    res = [0]
    res = deque(res)
    index = len(food) - 1
    for i in food[::-1]:
        half = i // 2
        for j in range(half):
            res.append(str(index))
            res.appendleft(str(index))
        index -= 1
    answer = '' 
    for i in res:
        answer += str(i)
    return answer