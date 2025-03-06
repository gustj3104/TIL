import sys
input = sys.stdin.readline

K, L = map(int, input().split())
for i in range(2, L):
    if i * i > K:
        break
    if K % i == 0:
        print("BAD", i)
        exit(0)
    
print("GOOD")