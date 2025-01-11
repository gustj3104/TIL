import sys
input = sys.stdin.readline

a, b = map(int, input().split())
c, d = map(int, input().split())

total = min(a+d, b+c)
print(total)