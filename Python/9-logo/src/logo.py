
def logo_play():
    """write your code in method"""
    board = [[0 for i in range(10)] for j in range(10)]
    n = int(input())
    x = 0
    y = 0
    isError = 0
    for i in range(1, n + 1):
        order = input()
        if len(order.split()) == 3:
            character = order.split()[2]
        step = int(order.split()[1])
        direction = order.split()[0]
        if direction == "U":
            if x - step < 0:
                isError = 1
                break
            for j in range(x - 1, x - 1 - step, -1):
                board[j][y] = character
            x = x - step
        if direction == "D":
            if x + step > 9:
                isError = 1
                break
            for j in range(x + 1, x + 1 + step):
                board[j][y] = character
            x = x + step
        if direction == "L":
            if y - step < 0:
                isError = 1
                break
            for j in range(y - 1, y - 1 - step, -1):
                board[x][j] = character
            y = y - step
        if direction == "R":
            if y + step > 9:
                isError = 1
                break
            for j in range(y + 1, y + 1 + step):
                board[x][j] = character
            y = y + step
    if isError == 1:
        print("Error!")
    else:
        for i in range(0, 10):
            for j in range(0, 10):
                if board[i][j] == 0:
                    print(" ", end='')
                else:
                    print(board[i][j], end='')
            print()
    return
