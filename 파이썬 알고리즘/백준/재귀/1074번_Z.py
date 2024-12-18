import sys
input = sys.stdin.readline

def Z(n, r, c):
    if(n == 0):
        return 0
    size = 2 ** (n-1)
    quad = size * size

    if r < size and c < size:
        #1사분면
        return Z(n-1, r, c)
    elif r < size and c >= size:
        #2사분면
        return quad + Z(n-1, r, c-size)
    elif r >= size and c < size:
        # 3사분면
        return 2 * quad + Z(n-1, r - size, c)
    elif r >= size and c >= size:
        # 4사분면
        return 3 * quad + Z(n-1, r-size, c-size)

n, r, c = map(int, input().split())
print(Z(n, r, c))