import heapq

def solution(k, score):
    heap, res = [], []
    for i in score:
        if len(heap) == k:
            if heap[0] >= i:
                res.append(heap[0])
            else:
                heapq.heappop(heap)
                heapq.heappush(heap, i)
                res.append(heap[0])
        else:
            heapq.heappush(heap, i)
            res.append(heap[0])
    return res