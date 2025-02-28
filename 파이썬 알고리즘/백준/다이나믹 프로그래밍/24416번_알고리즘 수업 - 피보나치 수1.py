import sys
input = sys.stdin.readline

n = int(input())

def dp_count(n):
    dp_recursion = [0] * (n + 1)
    dp_recursion[1] = 1
    dp_recursion[2] = 1

    for i in range(3, n + 1):
        dp_recursion[i] = dp_recursion[i-1] + dp_recursion[i-2]

    return dp_recursion[n]

print(dp_count(n), n - 2)