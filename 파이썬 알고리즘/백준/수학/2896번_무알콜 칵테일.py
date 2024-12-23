# 칵테일을 만들기 위해 필요한 오렌지, 사과, 파인애플 주스의 비율과 구매한 양이 주어짐. 최대한 많이 만들었을때 얼마나 남을지
import sys
input = sys.stdin.readline

# 구매한 오렌지, 사과, 파인애플 주스의 양
a, b, c = map(int, input().split())

# 필요한 각 주스의 비율
i, j, k = map(int, input().split())
m = min(a/i, b/j, c/k)
print(a - (m*i), b - (m*j), c - (m*k))

