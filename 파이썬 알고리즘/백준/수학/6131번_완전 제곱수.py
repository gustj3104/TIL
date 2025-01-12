# A의 제곱 = B의 제곱 + N 
# N을 알 때 (A, B) 쌍의 개수 찾기

# n = a^2 - b^2
import sys
import math
input = sys.stdin.readline

n = int(input())
a = list()
result = set()
i = 0

while i < n:
    i += 1
    a.append(i * i)

for m in a:
    for k in a:
        if m - k == n:
            result.add((m, k))

print(len(result))