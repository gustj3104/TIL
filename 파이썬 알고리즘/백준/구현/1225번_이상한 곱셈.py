import sys
input = sys.stdin.readline

a, b = input().strip().split()

a_sum = sum(map(int, a))
b_sum = sum(map(int, b))

print(a_sum * b_sum)