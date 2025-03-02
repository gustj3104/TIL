import sys
input = sys.stdin.readline

K, L = map(int, input().split())
min_factor = K # 최소 소인수

for i in range(2, int(K**0.5) + 1):
    if K % i == 0:
        min_factor = i
        break

if min_factor >= L:
    print("GOOD")
else:
    print("BAD", min_factor)
