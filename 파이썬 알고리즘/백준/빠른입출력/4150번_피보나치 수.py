def fibonacci(n):
    if n == 1 or n == 2:
        return 1
    
    a, b = 1, 1
    for _ in range(n - 2):
        a, b = b, a + b
    
    return b

# 입력
n = int(input())
print(fibonacci(n))
