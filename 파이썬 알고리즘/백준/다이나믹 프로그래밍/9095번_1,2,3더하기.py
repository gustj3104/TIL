import sys
input = sys.stdin.readline

def count(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4

    dp = [0] * (n + 1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for i in range(4, n + 1):
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

    return dp[n]

t = int(input())  # 테스트 케이스 수

for _ in range(t):
    s = int(input())
    print(count(s))
