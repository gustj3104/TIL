import sys
input = sys.stdin.readline

x = input().strip()
x_list = [(int(x[0]) * int(x[len(x) - 1]))]
while True:
    x = (int(x[0]) * int(x[len(x) - 1]))
    x_list.append(x)
    if x_list.pop() == x:
        print("FA")
        break