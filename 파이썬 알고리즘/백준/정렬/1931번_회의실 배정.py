'''
한 개의 회의실 -> N개의 회의에 대해 사용표 만들기
각 회의의 시작, 끝나는 시간을 알 때, 겹치지 않게 회의실을 사용할 수 있는 최대 개수 찾기

끝나자마자 시작 가능, 회의 중간에 중단 불가능능
'''
import sys
input = sys.stdin.readline

n = int(input()) # 회의 수

schedule = []
for _ in range(n):
    s, e = map(int, input().split()) # 시작 시간/끝나는 시간
    schedule.append([s, e])

schedule.sort(key=lambda x:(x[1], x[0]))

result = 0
end_time = 0

for s, e in schedule:
    if s >= end_time:
        result += 1
        end_time = e

print(result)