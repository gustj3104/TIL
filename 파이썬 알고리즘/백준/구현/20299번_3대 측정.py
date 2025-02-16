'''
전체 레이팅 > L && 레이팅 합 > K
'''
import sys
input = sys.stdin.readline

N, K, L = map(int, input().split())

team_count = 0
team_rating = []
for _ in range(N):
    x, y, z = map(int, input().split())
    if x >= L and y >= L and z >= L and (x + y + z) >= K:
        team_count += 1
        team_rating.append(x)
        team_rating.append(y)
        team_rating.append(z)

print(team_count)
print(" ".join(map(str, team_rating)))