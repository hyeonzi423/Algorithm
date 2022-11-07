def solution(nums):
    answer = len(list(set(nums))) if len(list(set(nums))) < int(len(nums)/2) else int(len(nums)/2)
    return answer