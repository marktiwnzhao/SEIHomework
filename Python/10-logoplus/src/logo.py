def logo_play():
    """write your code here :)"""
    board = [[' ' for i in range(10)] for j in range(10)]
    x = 0
    y = 0
    isPen = True
    isError = False
    character = ' '


    def Move(direction, step, x, y, isPen):
        for i in range(step):
            if direction == 'U':
                x -= 1
            elif direction == 'D':
                x += 1
            elif direction == 'L':
                y -= 1
            else:
                y += 1
            if x > 9 or x < 0 or y > 9 or y < 0:
                return x, y, True
            if isPen:
                board[x][y] = character
        return x, y, False

    def Cross(length, x, y):
        if x + length > 9 or x - length < 0 or y + length > 9 or y - length < 0:
            return True
        for i in range(x - length, x + length + 1):
            board[i][y] = character
        for i in range(y - length, y + length + 1):
            board[x][i] = character
        return False

    def Rect(length, height, x, y):
        if x + height > 10 or y + length > 10:
            return True
        for i in range(y, y + length):
            board[x][i] = character
            board[x + height - 1][i] = character
        for i in range(x, x + height):
            board[i][y] = character
            board[i][y + length - 1] = character
        return False

    def Rect_f(length, height, x, y):
        if x + height > 10 or y + length > 10:
            return True
        for i in range(x, x + height):
            for j in range(y, y + length):
                board[i][j] = character
        return False

    while True:
        operation = input().strip()
        if operation == 'end':
            break
        elif operation == 'pen_up':
            isPen = False
        elif operation == 'pen_down':
            isPen = True
        else:
            op = operation.split()
            if op[0] == 'move':
                if len(op) == 4:
                    character = op[3]
                x, y, isError = Move(op[1], int(op[2]), x, y, isPen)
            if op[0] == 'cross':
                if len(op) == 3:
                    character = op[2]
                isError = Cross(int(op[1]), x, y)
            if op[0] == 'rect':
                if len(op) == 4:
                    character = op[3]
                isError = Rect(int(op[1]), int(op[2]), x, y)
            if op[0] == 'rect_f':
                character = op[3]
                isError = Rect_f(int(op[1]), int(op[2]), x, y)

    if isError:
        print('Error!')
    else:
        for i in range(10):
            for j in range(10):
                print(board[i][j], end='')
            print()
    return