import sys
input = sys.stdin.readline

index = 0
while True:
    index += 1
    n = list(input())
    if int(n[0]) == 0:
        break
    print("Case %d: Sorting... done!" %(index))
    