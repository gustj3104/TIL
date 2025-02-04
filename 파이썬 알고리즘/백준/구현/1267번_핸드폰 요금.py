import sys
input = sys.stdin.readline

n = int(input())
call = list(map(int, input().split()))
y = 0
m = 0

for c in call:
    y += (c // 30 + 1) * 10 #영식 요금제
    m += (c // 60 + 1)* 15 #민식 요금제

if y < m:
    print("Y", y)
elif y == m:
    print("Y M", m)
else:
    print("M", m)