import sys
input = sys.stdin.readline
m = 0

for i in range(9):
    n = list(map(int, input().split()))
    if max(n) >= m:
        m = max(n)
        row = i
        col = n.index(m)

print(m)
print(row + 1, col + 1)