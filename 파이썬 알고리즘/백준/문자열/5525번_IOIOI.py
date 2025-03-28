'''
PN = I, o 교대로 나오는 문자열, N = o의 개수
S, N이 주어졌을 때, S 안에 Pn이 몇 군데 포함되어있는지 구하기
N -> Pn 만들기

for i in range(0, len(s) - len(pn))
s[i:i+3].join("") == "Pn" 이면 count += 1

'''

import sys
input = sys.stdin.readline

N = int(input())
s_length = int(input())
s = input().strip()

count = 0
i = 0 # 인덱스
pattern_count = 0 # 연속된 "IO" 개수

while i < s_length - 1:
    if s[i:i+3] == "IOI":
        pattern_count += 1
        if pattern_count >= N: # OI가 N개 이상이면 Pn 포함
            count += 1
        i += 2 # IOI 건너뜀
    else:
        pattern_count = 0
        i += 1

print(count)