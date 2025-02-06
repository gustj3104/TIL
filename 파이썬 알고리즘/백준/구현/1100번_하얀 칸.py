# 하얀 칸 위에 말이 몇 개 있는지 출력 (0, 0)부터 하얀칸이 번갈아가며 나옴
import sys
input = sys.stdin.readline

white = 0
field = []

# 체스판 입력
for _ in range(8):
    s = list(input().strip())
    field.append(s)

for i in range(8):
    for j in range(i % 2, 8, 2):
        if field[i][j] == 'F':
            white += 1

print(white)