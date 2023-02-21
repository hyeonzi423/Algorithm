import sys
from queue import PriorityQueue
input = sys.stdin.readline

N = int(input())
pq = PriorityQueue()
for i in range(N):
    tmp = int(input())
    if tmp > 0:
        pq.put(tmp)
    elif tmp == 0:
        if pq.qsize() > 0:
            print(pq.get())
        else:
            print(0)