import sys
input = sys.stdin.readline

n = int(input())
'''
position = 0
direction = "down"

mole = 1 # 분모
nume = 1 # 분자

while True:
    position += 1
    if position == n:
        print("%d/%d" %(nume, mole))
        break

    if direction == "down" and nume == 1:
        direction = "up"
        mole += 1
    elif direction == "down":
        nume -= 1
        mole += 1
    elif direction == "up" and mole == 1:
        direction = "down"
        nume += 1
    elif direction == "up":
        mole -= 1
        nume += 1
'''

line = 1 # 대각선 번호

#(line * (line + 1)) // 2 : 대각선 내의 분수의 총 개수
while (line * (line + 1)) // 2 < n: # 요소가 n을 넘어서면 다음 대각선으로
    line += 1

# 현재 대각선 내의 위치
position_in_line = n - (line * (line - 1)) // 2

if line % 2 == 0: #대각선 번호가 짝수인 경우
    nume = position_in_line
    mole = line - position_in_line + 1
else:
    nume = line - position_in_line + 1
    mole = position_in_line

print(f"{nume}/{mole}")