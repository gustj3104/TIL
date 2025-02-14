import sys
input = sys.stdin.readline

while True:
    s = list(map(int, input().split()))
    age = s.pop(0)
    if age == 0:
        break

    branch = 1
    while s:
        sf = s.pop(0) #split factor
        prun = s.pop(0) #가지치기 한 가지 수
        branch = branch * sf
        branch -= prun

    print(branch)
