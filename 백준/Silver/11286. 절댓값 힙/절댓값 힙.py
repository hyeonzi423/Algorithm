import sys
import heapq
input = sys.stdin.readline

N = int(input())
heap = []
for i in range(N):
    tmp = int(input())
    if tmp != 0:
        tmp2 = -tmp if tmp < 0 else tmp
        heapq.heappush(heap, (abs(tmp), tmp))
    else:
        if len(heap) > 0:
            print(heapq.heappop(heap)[1])
        else:
            print(0)