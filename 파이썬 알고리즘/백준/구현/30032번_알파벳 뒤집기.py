'''
D: 알파벳 뒤집기 방향 
D = 1 -> 상하
D = 2 -> 좌우
'''
import sys
input = sys.stdin.readline

n, d = map(int, input().split())

for _ in range(n):
    word = list(input().strip())
    result = []
    for w in word:
        if d == 1:
            if w == "d":
                result.append("q")
            elif w == "b":
                result.append("p")
            elif w == "q":
                result.append("d")
            elif w == "p":
                result.append("b")
        if d == 2:
            if w == "d":
                result.append("b")
            elif w == "b":
                result.append("d")
            elif w == "q":
                result.append("p")
            elif w == "p":
                result.append("q") 
    print("".join(result))