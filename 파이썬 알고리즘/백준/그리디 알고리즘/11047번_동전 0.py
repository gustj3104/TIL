# N 종류의 동전을 가지고 합을 K로 만들기 -> 필요한 동전 개수의 최솟값
import sys
input = sys.stdin.readline

n, k = map(int, input().split()) # n: 동전 종류, k: 만들어야 할 가치의 합

money = list()
for _ in range(n):
    i = int(input())
    money.append(i)
money.reverse()

result = 0
total = 0

for i in range(len(money)):
    result += k // money[i]
    k = k % money[i]

print(result)

