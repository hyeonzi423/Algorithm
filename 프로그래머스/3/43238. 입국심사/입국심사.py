def solution(n, times):
    left, right = 1, max(times) * n
    while left < right:
        mid, people = (left + right) // 2, 0
        for t in times:
            people += mid // t
        if people >= n:
            right = mid
        else:
            left = mid + 1
    return left