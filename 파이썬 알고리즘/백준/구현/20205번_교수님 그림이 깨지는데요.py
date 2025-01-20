n, k = map(int, input().split())
field = []

for _ in range(n):
    s = input().split()
    field.append(s)

pixel = [[0 for _ in range(n * k)] for _ in range(n * k)]

def upsampling(row, col):
    flag = field[row // k][col // k]
    pixel[row][col] = flag

for row in range(n * k):
    for col in range(n * k):
        upsampling(row, col)

for row in pixel:
    print(" ".join(row))
