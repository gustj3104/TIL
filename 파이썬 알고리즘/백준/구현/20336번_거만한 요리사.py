import sys
import random
input = sys.stdin.readline

n = int(input()) #메뉴의 수
menu = []
for _ in range(n):
    d, *food = input().strip().split()
    menu.append([d, food])

i = random.randrange(0, n)
print(menu[i][0])
for f in menu[i][1]:
    print(f)