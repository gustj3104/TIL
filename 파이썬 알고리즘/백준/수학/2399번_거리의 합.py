import sys
input = sys.stdin.readline

n = int(input())
x = list(map(int, input().split()))

# 점들을 정렬
x.sort()

# 누적 합 계산
prefix_sum = [0] * n
prefix_sum[0] = x[0]
for i in range(1, n):
    prefix_sum[i] = prefix_sum[i - 1] + x[i]

# 거리 합 계산
result = 0
for i in range(n):
    # 왼쪽 거리 합
    left = i * x[i] - prefix_sum[i - 1] if i > 0 else 0
    # 오른쪽 거리 합
    right = (prefix_sum[n - 1] - prefix_sum[i]) - (n - i - 1) * x[i] if i < n - 1 else 0
    result += left + right

print(result)

'''
import sys
temp=0
n=int(input())
nums=list(map(int,sys.stdin.readline().split())) #한줄만 입력받을땐 그냥 split()함수사용

for i in nums:
    for value in nums:
        temp+=abs(i-value)
print(temp)
'''