import sys
import math
input = sys.stdin.readline

L = int(input()) # 방학 일 수
A = int(input()) # 총 국어 페이지 수
B = int(input()) # 총 수학 페이지 수
C = int(input()) # 하루 최대 국어 페이지 수
D = int(input()) # 하루 최대 수학 페이지 수
math_days = math.ceil((B / D))
korean_days = math.ceil((A / C))
if math_days >= korean_days:
    L -= math_days
    print(L)
else:
    L -= korean_days
    print(L)