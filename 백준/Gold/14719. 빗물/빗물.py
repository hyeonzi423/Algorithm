h, w = map(int, input().split())
arr = list(map(int, input().split()))

left, right = 0, len(arr) - 1
max_left, max_right = arr[left], arr[right]
answer = 0

while left < right:
    max_left = max(max_left, arr[left])
    max_right = max(max_right, arr[right])
    if max_left >= max_right:
        answer += max_right - arr[right]
        right -= 1
    else:
        answer += max_left - arr[left]
        left += 1
print(answer)