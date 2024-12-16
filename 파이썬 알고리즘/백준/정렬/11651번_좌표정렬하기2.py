import sys
input = sys.stdin.readline

n = int(input())
pos = []

for i in range(n):
    x, y = map(int, input().split())
    pos.append((x, y))

pos = sorted(pos, key = lambda x : (x[1], x[0]))

for i in pos:
    print(i[0], i[1])
    