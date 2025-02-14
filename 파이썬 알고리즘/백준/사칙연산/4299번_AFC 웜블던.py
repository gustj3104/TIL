import sys
input = sys.stdin.readline

sum, diff = map(int, input().split())

if sum == 0 and diff == 0: 
    print(0, 0)
    exit(0)

for a in range(sum):
    for b in range(sum):
        if (a + b) == sum and (a - b) == diff:
            print(a, b)
            exit(0)

print(-1) #합, 차를 갖는 경기 결과가 없는 경우