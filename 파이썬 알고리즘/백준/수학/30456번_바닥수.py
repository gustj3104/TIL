import sys
input = sys.stdin.readline
n, l = map(int, input().split()) # n: 바닥수, l: P의 자릿수

for i in range(l-1):
    print(1, end = "")

print(n)