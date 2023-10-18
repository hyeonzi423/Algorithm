def solution(nums):
    n = len(nums)//2
    nums = len(set(nums))
    return n if nums > n else nums