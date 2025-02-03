import sys
input = sys.stdin.readline

def find_ab(n, m):
    count = 0
    for a in range(1, n):
        for b in range(a + 1, n):
            case = (a**2 + b**2 + m) / (a * b)
            if case.is_integer():  # 정수인지 확인
                count += 1
    return count

t = int(input())  # 테스트 케이스 개수

for _ in range(t):
    n, m = map(int, input().split())
    print(find_ab(n, m))