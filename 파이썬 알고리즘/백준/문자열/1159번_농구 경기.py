import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input()) # 선수 수
player_first = defaultdict(int)
for _ in range(n):
    p = input().strip()
    player_first[p[0]] += 1

player = [f for f in player_first if player_first[f] >= 5]

if player:
    player.sort()
    print("".join(player))
else:
    print("PREDAJA")
