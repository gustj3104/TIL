import sys
input = sys.stdin.readline

print("Gnomes:")
t = int(input())
for _ in range(t):
    n = list(map(int, input().split()))
    origin = n[:]
    if n == sorted(n):
        print("Ordered")
    elif n == sorted(n, reverse=True):
        print("Ordered")
    else:
        print("Unordered")
