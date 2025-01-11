import sys
input = sys.stdin.readline

P, k = map(int, input().split())

def prime_number(limit):
    is_prime = [True] * (limit + 1)
    is_prime[0], is_prime[1] = False, False # 0, 1은 소수 아님
    for start in range(2, int(limit**0.5) + 1):
        if is_prime[start]:
            for multiple in range(start * start, limit + 1, start):
                is_prime[multiple] = False
    return [num for num, prime in enumerate(is_prime) if prime]

prime_numbers = prime_number(k-1)

for p in prime_numbers:
    if P % p == 0:
        print("BAD", p)
        sys.exit()

print("GOOD")