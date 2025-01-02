import sys
input = sys.stdin.readline

# 마지막 자릿수의 주기 테이블
last_digit_cycles = {
    0: [0], 
    1: [1], 
    2: [2, 4, 8, 6], 
    3: [3, 9, 7, 1],
    4: [4, 6],
    5: [5],
    6: [6],
    7: [7, 9, 3, 1],
    8: [8, 4, 2, 6],
    9: [9, 1]
}

n = int(input())
for _ in range(n):
    a, b = map(int, input().split())
    last_digit = a % 10  # a의 마지막 자릿수
    cycle = last_digit_cycles[last_digit]  # 주기 가져오기
    
    if b == 0:  # b가 0이면 a^b는 1
        print(1)
    else:
        # b-1을 주기의 길이로 나눠서 인덱스 계산
        index = (b - 1) % len(cycle)
        result = cycle[index]
        # 마지막 자릿수가 0이면 10 출력
        if result == 0:
            print(10)
        else:
            print(result)
