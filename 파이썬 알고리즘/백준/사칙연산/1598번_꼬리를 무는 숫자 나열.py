import sys
input = sys.stdin.readline

n, m = map(int, input().split()) 
if n > m:
    n, m = m, n  

row_distance = abs((m - 1) // 4 - (n - 1) // 4)
col_distance = abs((m - 1) % 4 - (n - 1) % 4)
distance = row_distance + col_distance

print(distance)
