import sys
input = sys.stdin.readline

# 요리 재료 종류의 개수
n = int(input())

# 필요한 요리 재료
need = set(input().strip().split())

# 사용한 재료
use = set(input().split())

print(" ".join(need.difference(use)))