'''
택시 기하학에서 점 사이의 거리 = D(T1,T2) = |x1-x2| + |y1-y2|
택시 기하학에서 원의 정의 = 유클리드 기하학에서 원의 정의
-> 반지름으로 유클리드 기하학의 원의 넓이, 택시 기하학의 원의 넓이 구하기
(원의 넓이는 반지름^2 * pi)
'''
import sys
import math
input = sys.stdin.readline
pi = math.pi

r = int(input())

uclidean = r * r * pi
taxi = r * r * 2

print(uclidean)
print(taxi)