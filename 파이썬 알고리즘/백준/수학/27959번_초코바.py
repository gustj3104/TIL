# 100원 동전 n개, m원짜리 초코바를 사먹을 수 있을지
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
if (100 * n >= m):
    print("Yes")
else:
    print("No")