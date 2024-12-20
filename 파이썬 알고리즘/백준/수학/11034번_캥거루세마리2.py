def max_moves(a, b, c):
    left_gap = b - a
    right_gap = c - b
    return max(left_gap, right_gap) - 1

while True:
    try:
        a, b, c = map(int, input().split())
        if not (0 < a < b < c < 100):
            print()
            continue
        print(max_moves(a, b, c))
    except EOFError:
        break
