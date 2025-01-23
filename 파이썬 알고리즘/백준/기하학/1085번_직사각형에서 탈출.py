# 왼쪽 아래 = 0,0 / 오른쪽 위 = w, h / 현재 위치 = x, y
# 직사각형 경계선까지 가는 최솟값 구하기
# x-w , y-h의 절댓값 중 최소값 구하기 vs x-0부터 y-o중 최솟값 구하기 1번 2번 비교해서 최솟값 구하기
import sys
input = sys.stdin.readline

x, y, w, h = map(int, input().split())
right_top = min(abs(x-w), abs(y-h))
left_bottom = min(abs(x-0), abs(y-0))
print(min(right_top, left_bottom))
