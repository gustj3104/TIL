'''sys.stdin.readline / .rstrip()을 사용하여 A+B출룍'''
import sys

T=int(input())

for i in range(T):
    a=sys.stdin.readline().rstrip()
    A, B=map(int, a.split())
    print(A+B)