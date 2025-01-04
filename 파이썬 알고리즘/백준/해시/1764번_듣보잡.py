import sys
input = sys.stdin.readline

n, m = map(int, input().split())  # 듣X, 보X 사람 수

# 듣도 못한 명단
not_listen = set(input().strip() for _ in range(n))

# 보도 못한 명단
not_see = set(input().strip() for _ in range(m))

# 교집합으로 구하기기
result = sorted(not_listen & not_see)

print(len(result))
for name in result:
    print(name)
