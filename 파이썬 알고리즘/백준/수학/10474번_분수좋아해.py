import sys
input = sys.stdin.readline

while True:
    up, down = map(int, input().split())
    if up == 0 and down == 0:
        break

    num = up // down
    frac = up % down

    print(num, frac, "/", down)
