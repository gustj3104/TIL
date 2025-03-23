import sys
input = sys.stdin.readline

N = int(input())
result_x, result_y = map(int, input().split())  

for _ in range(N - 1):  
    x, y = map(int, input().split())
    if y < result_y or (y == result_y and x < result_x):  # 가장 남쪽 or 동일 높이면 x 작은 것 선택
        result_x, result_y = x, y

print(result_x, result_y)
