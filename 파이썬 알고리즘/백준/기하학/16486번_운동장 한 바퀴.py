''' 
A, B는 반원, C는 직사각형
C의 가로 길이 = d1
A의 반지름 길이 = d2

운동장 한 바퀴 둘레 알아내기

둘레 = A의 둘레 + C의 가로 길이 * 2
A의 둘레 = 2 * pi * 반지름
'''
import sys
input = sys.stdin.readline

d1 = int(input()) # 직사각형 가로
d2 = int(input()) # 원 반지름
pi = 3.141592

print(2*pi*d2 + d1*2)