n = int(input())
max_n = n * 2 - 1
for i in range(1, n+1):
    print(" " * ((max_n - (2 * i - 1)) // 2), end="")  # 왼쪽 공백
    print("*" * (2 * i - 1)) 
