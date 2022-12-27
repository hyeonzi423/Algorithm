def solution(numlist, n):
    answer = []
    numlist_d = {i:0 for i in numlist}
    for i in range(len(numlist)):
        numlist_d[numlist[i]] += abs(n - numlist[i])
    numlist_d = sorted(numlist_d.items(), key = lambda x: (x[1], -x[0]))
    for i in numlist_d:
        answer.append(i[0])
    return answer