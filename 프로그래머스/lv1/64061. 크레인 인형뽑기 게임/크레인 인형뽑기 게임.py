def solution(board, moves):
    answer, basket = 0, []
    for i in moves:
        for j in range(len(board)):
            if board[j][i-1] != 0:
                if len(basket) !=0 and basket[-1] == board[j][i-1]:
                    basket.pop()
                    answer += 2
                else:
                    basket.append(board[j][i-1])
                board[j][i-1] = 0
                break
            else:
                continue
    return answer