def delete(m, n, board):
    delete = []
    for i in range(m - 1):
        for j in range(n - 1):
            tmp = board[i][j]
            if tmp != 0 and tmp == board[i][j + 1] and tmp == board[i + 1][j] and tmp == board[i + 1][j + 1]:
                delete.append((i, j))
                delete.append((i, j + 1))
                delete.append((i + 1, j))
                delete.append((i + 1, j + 1))
    delete = set(delete)
    for x, y in delete:
        board[x][y] = 0
    return board, len(delete)


def down(m, n, board):
    for y in range(n):
        for x in range(m - 1, -1, -1):
            if board[x][y] == 0:
                tmp = x - 1
                while tmp >= 0:
                    if board[tmp][y] != 0:
                        board[x][y] = board[tmp][y]
                        board[tmp][y] = 0
                        break
                    else:
                        tmp -= 1
    return board


def solution(m, n, board):
    answer = 0
    board = [list(x) for x in board]
    board, count = delete(m, n, board)
    answer += count
    while count > 0:
        down(m, n, board)
        board, count = delete(m, n, board)
        answer += count

    return answer