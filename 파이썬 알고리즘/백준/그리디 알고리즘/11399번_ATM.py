'''
ATM 앞 N명의 사람이 줄을 서있음. i번째 사람이 돈을 인출할 때 걸리는 시간 = pi
-> 각 사람이 인출하는데 필요한 시간의 합을 최소로 만들기
'''

import sys
input = sys.stdin.readline

n = int(input()) # 사람 수
time = list(map(int, input().split()))
time.sort()
total = 0
last = 0
for i in time:
    last += i
    total += last

print(total)