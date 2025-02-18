import sys
input = sys.stdin.readline
n = int(input()) # 멀티탭 수

result = 0
for c in range(n):
    plug = int(input()) # 각 멀티탭의 수용 가능한 플러그 수
    if c == n - 1:
        result += plug
    else:
        result += (plug - 1)

print(result)