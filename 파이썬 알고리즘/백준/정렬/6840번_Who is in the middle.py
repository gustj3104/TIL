import sys
input = sys.stdin.readline

bowl = list()
for i in range(3):
    n = int(input())
    bowl.append(n)

bowl.sort()
print(bowl[1])