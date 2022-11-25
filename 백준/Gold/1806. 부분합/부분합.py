n, s = map(int, input().split())
num = list(map(int, input().split()))
left, right, hap, answer = 0, 0, 0, 100001

while True:
    if hap >= s:
        answer = min(answer, right - left)
        hap -= num[left]
        left += 1
    else:
        if right == n:
            break
        hap += num[right]
        right += 1
print(answer if answer != 100001 else 0)