'''
x좌표 정렬 -> y좌표 정렬
'''
pos = []
n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    pos.append([x, y])

pos = sorted(pos, key=lambda x: (x[0], x[1]))
for i in range(n):
    print(pos[i][0], pos[i][1])