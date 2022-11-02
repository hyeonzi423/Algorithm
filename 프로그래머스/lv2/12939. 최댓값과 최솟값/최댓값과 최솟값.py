def solution(s):
    tmp = list(map(int, s.split()))
    answer = str(min(tmp)) + " " + str(max(tmp)) 
    return answer