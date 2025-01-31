import sys
input = sys.stdin.readline

for _ in range(3):
    total = 0
    n = int(input())
    for _ in range(n):
        i = int(input())
        total += i
    if total == 0:
        print("0")
    elif total > 0:
        print("+")
    else:
        print("-")