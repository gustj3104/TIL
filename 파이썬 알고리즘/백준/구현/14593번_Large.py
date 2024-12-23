import sys
input = sys.stdin.readline

n = int(input()) #참가자 수

player = []
count = 0 # 순위위
for _ in range(n):
    s, c, l = map(int, input().split())
    count += 1
    player.append((s, c, l, count))

player.sort(key = lambda x: [x[0], -x[1], -x[2]])
player.reverse()

print(player[0][3])