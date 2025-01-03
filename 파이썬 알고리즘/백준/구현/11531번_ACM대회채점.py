# 패널티 = 문제를 맞힌 시각 + 틀린 횟수 * 20 // 아무 문제도 못 푼 경우 패널티 = 0
import sys
input = sys.stdin.readline
total = dict()
penalty = 0 # 패널티 포함 시간간
count = 0 # 푼 문제 수

while True:
    n = input().strip()
    if n == "-1":
        break
    else:
        time, name, result = n.split()
        if name not in total:
            total[name] = 0

        if result == 'wrong':
            total[name] += 1
        else:
            penalty = penalty + int(time) + total[name] * 20
            count += 1


print(count, penalty)