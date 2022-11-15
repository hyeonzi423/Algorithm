def solution(skill, skill_trees):
    answer = 0
    for tree in skill_trees:
        check = ''
        for t in tree:
            if t in skill:
                check += t
        if skill[:len(check)] == check:
            answer += 1
    return answer