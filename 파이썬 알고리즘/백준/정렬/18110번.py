import sys
import math
input = sys.stdin.readline
def custom_round(value):
    # Ex) 3.2이면 int(3.2) = 3이 됨
    return int(value + 0.5) if value > 0 else int(value - 0.5)

n = int(input())

if n == 0:  # 의견이 없으면 난이도 = 0
    print(0)
    sys.exit()

level = [int(input()) for _ in range(n)]
level.sort()  # 정렬

exclude = custom_round(n * 0.15)
valid_levels = level[exclude:n-exclude]  # 상하위 15% 제외

# 유효한 데이터가 있는지 확인
if len(valid_levels) == 0:
    print(0)
else:
    print(custom_round(sum(valid_levels) / len(valid_levels)))
