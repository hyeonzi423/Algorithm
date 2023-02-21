import sys
import heapq
input = sys.stdin.readline

N = int(input())
heap = []
for i in range(N):
    tmp = int(input())
    if tmp > 0:
        heapq.heappush(heap, -tmp)
    elif tmp == 0:
        if len(heap) > 0:
            print(-heapq.heappop(heap))
        else:
            print(0)