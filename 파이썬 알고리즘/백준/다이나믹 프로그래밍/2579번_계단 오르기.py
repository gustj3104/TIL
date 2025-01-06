import sys
input = sys.stdin.readline

n = int(input()) # 계단 개수
stairs = []

for _ in range(n):
    a = int(input())
    stairs.append(a)

def count(step):
    if len(step) == 1:
        return step[0]
    if len(step) == 2:
        return step[0] + step[1]

    dp = [0] * len(step)
    dp[0] = step[0]
    dp[1] = step[0] + step[1]
    dp[2] = max(step[0] + step[2], step[1] + step[2]) # 1 + 3번째 계단 / 2 + 3번째 계단 중 큰 수 선택택

    for i in range(3, len(step)):
        # 두 계단 전에서 2칸 올라가서 i 번째 오는 경우 vs 세 계단 전에서 2칸 올라와서 i-1, i 밟기 중 큰 수 선택
        dp[i] = max(dp[i-2] + step[i], dp[i-3] + step[i-1] + step[i]) 

    return dp[len(step) - 1]

print(count(stairs))