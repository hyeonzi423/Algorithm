def solution(clothes):
    answer = 1
    item = {b: [] for a, b in clothes}
    for a, b in clothes:
        item[b].append(a)
    for k, v in item.items():
        answer *= (1+len(v))
    return answer-1