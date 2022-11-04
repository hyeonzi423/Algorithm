def solution(n):
    n_list = [i for i in str(n)]
    n_list2 = list(map(int,n_list))
    answer = n_list2[::-1]
    print(answer)
    return answer