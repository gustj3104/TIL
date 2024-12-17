# 메모이제이션을 위한 딕셔너리 초기화
memo = {}

def fibonacci(n):
    if n in memo:  # 이미 계산된 값이면 반환
        return memo[n]
    
    if n == 0:
        memo[n] = (1, 0)
        return memo[n]
    elif n == 1:
        memo[n] = (0, 1)
        return memo[n]
    else:
        left_zero, left_one = fibonacci(n-1)
        right_zero, right_one = fibonacci(n-2)
        
        memo[n] = (left_zero + right_zero, left_one + right_one)
        return memo[n]

# 입력 및 결과 출력
n = int(input(""))
for _ in range(n):
    a = int(input(""))
    zero_count, one_count = fibonacci(a)
    print(zero_count, one_count)
