n, k = map(int, input().split())
arr = list(map(int, input().split()))
tap = []
cnt = 0

for i in range(k):
    if arr[i] in tap:
        continue
    if len(tap) < n:
        tap.append(arr[i])
        continue

    index_l = []
    for t in tap:
        if t in arr[i:]:
            index = arr[i:].index(t)
        else:
            index = 101
        index_l.append(index)
    tap.remove(tap[index_l.index(max(index_l))])
    tap.append(arr[i])
    cnt += 1

print(cnt)