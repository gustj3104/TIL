# 정N각형의 꼭짓점을 이어만들 수 있는 서로 다른 별의 개수 출력

from math import comb

n = int(input())

# 조합의 개수를 math.comb로 계산
result = comb(n, 5)

print(result)
