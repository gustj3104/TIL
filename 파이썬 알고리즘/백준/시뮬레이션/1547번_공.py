import sys
input = sys.stdin.readline

m = int(input())
pos = 1
for _ in range(m):
    a, b = map(int, input().split())
    if pos == a:
        pos = b
    elif pos == b:
        pos = a 
    
print(pos)