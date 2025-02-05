'''
1. 길이가 같은 문자열 S, T 주어짐
2. S의 글자 x, x가 등장하는 위치 = P (항상 유일)
3. T의 P번째 글자를 읽으면 됨 (대문자로 변환하기)
'''
import sys
input = sys.stdin.readline

n = int(input()) # 테스트 케이스

result = ""
for _ in range(n):
    s, t = map(str, input().upper().split())
    target = s.index("X")
    final = t[target]
    result += final

print(result)