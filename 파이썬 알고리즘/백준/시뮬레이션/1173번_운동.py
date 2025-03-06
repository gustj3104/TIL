'''
운동을 하면 원래 맥박 + T < M이어야 함
휴식을 하면 원래 맥박 - R > m이어야 함

N분동안 운동하는데 필요한 시간의 최솟값
'''
import sys
input = sys.stdin.readline

N, m, M, T, R = map(int, input().split())

time = 0
count = 0 # 운동 시간
current_m = m # 현재 맥박

while count < N:
    if current_m + T <= M: # 운동
        current_m += T
        count += 1  
    else: # 휴식
        if current_m - R >= m:
            current_m -= R
        else: # 맥박 최소치 이하
            current_m = m
    
    if current_m + T > M and current_m == m:
        print(-1)
        exit(0)

    time += 1

print(time)