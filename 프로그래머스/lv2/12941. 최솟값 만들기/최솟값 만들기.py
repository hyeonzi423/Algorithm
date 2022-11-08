def solution(A,B):
    A.sort()
    B.sort(reverse = True)
    answer = sum([A[i] * B[i] for i in range(len(A))])
    return answer