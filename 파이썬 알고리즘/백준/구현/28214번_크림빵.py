n, k, p = map(int, input().split())
s = list(map(int, input().split()))

# 팔 수 있는 빵 묶음의 개수
result = 0

for i in range(n):
    # i번째 묶음의 범위 계산
    bundle = s[i * k:(i + 1) * k]
    
    # 한 묶음 안 크림 없는 빵 검사사
    if bundle.count(0) < p:
        result += 1

print(result)
