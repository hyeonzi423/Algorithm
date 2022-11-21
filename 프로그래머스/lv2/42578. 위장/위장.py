def solution(clothes):
    answer = 1
    hash_clothes = {cloth:[] for c, cloth in clothes}
    for a, b in clothes:
        hash_clothes[b].append(a)
    for key, value in hash_clothes.items():
        answer *= (1 + len(value))
    return answer - 1
