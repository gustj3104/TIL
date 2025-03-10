import sys
input = sys.stdin.readline

n = int(input())
result = list(map(int, input().split()))

sequence = 0 # 연속 횟수
score = 0 
for i in result:
    if i == 1:
        sequence += 1
        score += sequence * i
    elif i == 0:
        sequence = 0
        
print(score)
