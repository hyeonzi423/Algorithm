def solution(board, moves):
    answer, basket = 0, []
    for i in range(len(moves)):
        for j in range(len(board)):
            if board[j][moves[i]-1] != 0:
                if len(basket) !=0 and basket[-1] == board[j][moves[i]-1]:
                    basket.pop()
                    answer += 2
                else:
                    basket.append(board[j][moves[i]-1])
                board[j][moves[i]-1] = 0
                break
            else:
                continue
    return answer