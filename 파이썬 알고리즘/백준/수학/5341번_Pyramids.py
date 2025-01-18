import sys
input = sys.stdin.readline


while True:
    n = int(input())
    if n == 0:
        break
    blocks = n
    while True:
        n -= 1
        blocks += n
        if n <= 1:
            print(blocks)
            break