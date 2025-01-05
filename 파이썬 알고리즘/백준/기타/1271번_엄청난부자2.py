'''
돈 n을 m 개의 생명체에게 동등하게 나누기
'''
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
print(n//m)
print(n%m)