import sys

input = sys.stdin.readline

# 입력 받기
S, M = map(int, input().split())

ari_coins = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512]
ari_total = sum(ari_coins)  # 1023

# 1. 아리만으로 살 수 있는 경우
if S <= ari_total:
    print("No thanks")
    exit()

# 2. 부족한 금액 계산
needed = S - ari_total

# 3. 쿠기의 돈이 부족하면 불가능
if needed > M:
    print("Impossible")
    exit()

# 4. 쿠기가 가진 동전 목록 
cookie_coins = []
for i in range(10):  # 2^0 ~ 2^9 (1~512)
    if M & (1 << i):  # M의 i번째 비트가 1이면 해당 동전 포함
        cookie_coins.append(1 << i)

# 5. DP로 정확히 `needed` 금액을 만들 수 있는지 확인
dp = [False] * (M + 1)  # 쿠기가 가진 돈 M까지 가능한 경우 저장
dp[0] = True  # 0원은 항상 가능

for coin in cookie_coins:
    for i in range(M, coin - 1, -1):  # 중복 사용 방지 (역순 탐색)
        if dp[i - coin]:
            dp[i] = True

print("Thanks" if dp[needed] else "Impossible")
