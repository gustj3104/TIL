# 7초마다 한 사람 죽고, 4초마다 한 사람 태어날 때 인구 수
import sys
input = sys.stdin.readline

n = int(input()) # 테스트 케이스 수
for _ in range(n):
    p, t = map(int, input().split())
    minus = t // 7
    plus = t // 4
    p = p - minus + plus
    print(p)