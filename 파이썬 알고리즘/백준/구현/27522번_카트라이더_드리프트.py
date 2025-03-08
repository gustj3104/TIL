# 순위 점수 합계가 높은 팀이 승리함 -> 합계가 같은 경우 최고 순위가 가장 높은 팀이 승리함
import sys
input = sys.stdin.readline

score =[10, 8, 6, 5, 4, 3, 2, 1]
blue_score = 0
red_score = 0
time_list = []
# 1. min -> sc -> ms 변환해서 시간 계산
for _ in range(8):
    time, team = input().strip().split()
    minute, sc, ms = map(int, time.split(":"))
    t = ms + sc * 1000 + minute * 60 * 1000
    time_list.append((t, team))

time_list.sort()

for i, (_, team) in enumerate(time_list):
    if team == "B":
        blue_score += score[i]
    else:
        red_score += score[i]

if blue_score > red_score:
    print("Blue")
elif red_score > blue_score:
    print("Red")
else:
    winner = "Blue" if time_list[0][1] == "B" else "Red"
    print(winner)