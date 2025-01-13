# N명이 s 주식을 동등하게 공유 -> x = 각 사람이 취득한 주식 수 / x의 최대값 출력

import sys
input = sys.stdin.readline

while True:
    S = input().strip()
    if S == "":
        break
    else:
        n, s = map(int, S.split())
        print(s//(n+1))
