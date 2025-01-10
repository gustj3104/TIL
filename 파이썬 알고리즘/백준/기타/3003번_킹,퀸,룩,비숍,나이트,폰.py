import sys
input = sys.stdin.readline
 
need = [1, 1, 2, 2, 2, 8]
chess = list(map(int, input().split()))
result = [need[i] - chess[i] for i in range(6)]
print(' '.join(map(str, result)))
