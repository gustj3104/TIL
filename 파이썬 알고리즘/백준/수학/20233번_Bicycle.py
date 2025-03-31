# 월 a : 30분 무료 + 분마다 x씩 증가
# 월 b : 45분 무료 + 분마다 y씩 증가

a, x, b, y, time = (int(input()) for _ in range(5))

if time - 30 > 0:
    first = (time - 30) * x * 21
else: 
    first = 0

if time - 45 > 0:
    second = (time - 45) * y * 21
else:
    second = 0
print(first + a, second + b)