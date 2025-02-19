import sys
import math

def four_squares(n):
    if (n ** 0.5).is_integer():
        return 1  # n이 완전제곱수인 경우

    for i in range(1, int(math.sqrt(n)) + 1):
        if (n - i * i) ** 0.5 % 1 == 0:  # n - i^2가 완전제곱수인 경우우
            return 2

    # 단, n이 4^k * (8m + 7) 형태라면 반드시 4개 필요
    while n % 4 == 0:
        n //= 4
    if n % 8 == 7:
        return 4

    return 3

n = int(sys.stdin.readline().strip())
print(four_squares(n))
