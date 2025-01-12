
import sys
input = sys.stdin.readline

while True:
    num = int(input().rstrip())
    if num == 0:
        break
    roll = 1
    for i in range(num):
        line = input().rstrip()
        line += " "

        # 공백까지 오른쪽으로 이동
        while roll < len(line) and line[roll -1] != ' ':
            roll += 1

    print(roll)