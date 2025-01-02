# 가장 많은 자루 선택하기
import sys
input = sys.stdin.readline

n = int(input())

for i in range(n):
    sack_list = list(map(int, input().split()))
    print("Case #%d: %d" %((i+1), max(sack_list)))