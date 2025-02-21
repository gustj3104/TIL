'''
전송 장치 = 두 개의 금 -> 고리 두 개는 하나의 동일한 판으로부터 잘라야 함
호박마다 고리의 크기가 다름

구매한 금판으로 두 개의 고리를 자를 수 있을지
'''
import sys
input = sys.stdin.readline

# A, B : 두 고리의 바깥 반지름
# a, b : 두 고리의 안쪽 반지름
# P: 판의 반지름

A, a, B, b, P = map(int, input().split())

# A, B 중 더 큰 원 찾기기
if A >= B:
    big_outter_circle = A
    big_inner_circle = a
    small_outter_circle = B
    small_inner_circle = b
else:
    big_outter_circle = B
    big_inner_circle = b
    small_outter_circle = A
    small_inner_circle = a

# 더 큰 원의 안쪽 반지름이 작은 원의 바깥 반지름보다 작은지 검사
if big_inner_circle >= small_outter_circle and big_outter_circle <= P:
    print("Yes")
    exit(0)
if A + B <= 2 * P:
    print("Yes")
    exit(0)
print("No")