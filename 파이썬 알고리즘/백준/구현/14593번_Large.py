''' 
small, large 데이터로 이루어짐
small, large 각각 점수는 다름
제출 횟수 = 문제를 맞기까지 다운 횟수 총합 -> 못 맞추면 다운로드 횟수 포함X
문제점수 총합이 높을수록 높은 순위, 같은 경우 업로드 시간이 빠르면 높은 순위
'''
import sys
input = sys.stdin.readline

n = int(input()) #참가자 수

player = []
count = 0
for _ in range(n):
    s, c, l = map(int, input().split())
    count += 1
    player.append((s, c, l, count))

player.sort(key = lambda x: [x[0], -x[1], -x[2]])
player.reverse()

print(player[0][3])