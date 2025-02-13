import sys
input = sys.stdin.readline

n, m = map(int, input().split()) # n, m 까지의 거리 구하기
distance = 0
if n > m :
    n, m = m, n

distance = ((m-1) % 4) + ((m-1) // 4) 
print(distance)
# while True:   
#     if m == n:
#         print(distance)
#         break
#     if m - 4 >= n:
#         m -= 4
#         distance += 1 #가로로 이동
#     else:
#         m += 1
#         distance += 1 #세로로 이동
