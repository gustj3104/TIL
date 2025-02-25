import sys
input = sys.stdin.readline

N = int(input())
count = 0

# a == 0일 때
count += (2 * N + 1) ** 2  

# a ≠ 0일 때, b+c = 1-a인 경우
for a in range(-N, N + 1):
    if a != 0:
        k = 1 - a
        # b, c ∈ [-N, N]에서 b+c = k를 만족하는 해의 개수
        solutions = max(0, (2 * N - abs(k)) + 1)
        count += solutions

print(count)
