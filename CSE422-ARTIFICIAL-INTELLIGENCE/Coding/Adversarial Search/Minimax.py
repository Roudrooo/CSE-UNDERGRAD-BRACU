def minimax(position, depth, maximizingPlayer):
    winner = check_winner(position)

    # Base cases
    if winner == 'X':
        return 1
    if winner == 'O':
        return -1
    if is_draw(position):
        return 0

    if maximizingPlayer:  # X's turn
        maxEval = -float('inf')
        for child in get_children(position, 'X'):
            eval = minimax(child, depth - 1, False)
            maxEval = max(maxEval, eval)
        return maxEval

    else:  # O's turn
        minEval = float('inf')
        for child in get_children(position, 'O'):
            eval = minimax(child, depth - 1, True)
            minEval = min(minEval, eval)
        return minEval


# ─────────────────────────────────────────
# Board helpers
# ─────────────────────────────────────────

def check_winner(board):
    """Return 'X', 'O', or None."""
    wins = [
        [0,1,2], [3,4,5], [6,7,8],  # rows
        [0,3,6], [1,4,7], [2,5,8],  # cols
        [0,4,8], [2,4,6]            # diagonals
    ]
    for combo in wins:
        vals = [board[i] for i in combo]
        if vals == ['X','X','X']:
            return 'X'
        if vals == ['O','O','O']:
            return 'O'
    return None

def is_draw(board):
    """Return True if no empty cell and no winner."""
    return ' ' not in board

def get_children(board, player):
    """Return all boards after every legal move for player."""
    children = []
    for i in range(9):
        if board[i] == ' ':
            new_board = board.copy()
            new_board[i] = player
            children.append(new_board)
    return children

def print_board(board):
    for i in range(0, 9, 3):
        print(board[i], '|', board[i+1], '|', board[i+2])
    print('-' * 10)


# ─────────────────────────────────────────
# Best move finder
# ─────────────────────────────────────────

def best_move(board):
    """Find the best move for X (maximizing player)."""
    best_score = -float('inf')
    move = -1

    for i in range(9):
        if board[i] == ' ':
            board[i] = 'X'
            score = minimax(board, 0, False)  # after X moves, it's O's turn
            board[i] = ' '                    # undo move
            if score > best_score:
                best_score = score
                move = i
    return move


# ─────────────────────────────────────────
# Main game loop
# ─────────────────────────────────────────

def play_game():
    # 0 1 2
    # 3 4 5
    # 6 7 8
    board = [' '] * 9

    print("=== Tic-Tac-Toe: You (O) vs AI (X) ===\n")
    print("Board positions:")
    print("0 | 1 | 2")
    print("3 | 4 | 5")
    print("6 | 7 | 8\n")

    for turn in range(9):
        print_board(board)

        if turn % 2 == 0:           # AI plays as X on even turns
            print("AI (X) is thinking...")
            move = best_move(board)
            board[move] = 'X'
            print(f"AI chose position {move}\n")
        else:                        # Human plays as O on odd turns
            while True:
                try:
                    move = int(input("Your move (O) — enter position (0-8): "))
                    if board[move] == ' ':
                        board[move] = 'O'
                        break
                    else:
                        print("Cell taken, try again.")
                except (ValueError, IndexError):
                    print("Invalid input, enter a number 0–8.")

        winner = check_winner(board)
        if winner:
            print_board(board)
            print(f"{'AI (X)' if winner == 'X' else 'You (O)'} wins!")
            return

    print_board(board)
    print("It's a draw!")


# ─────────────────────────────────────────
play_game()