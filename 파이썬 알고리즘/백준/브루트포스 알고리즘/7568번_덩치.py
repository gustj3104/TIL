import sys
input = sys.stdin.readline

n = int(input())  # 전체 사람 수
p_list = []

# 입력 받기
for _ in range(n):
    x, y = map(int, input().split())
    p_list.append((x, y))

# 등수 계산
ranks = []
for i in range(n):
    rank = 1  # 기본 등수
    for j in range(n):
        if i != j and p_list[j][0] > p_list[i][0] and p_list[j][1] > p_list[i][1]:
            rank += 1
    ranks.append(rank)

# 출력
print(' '.join(map(str, ranks)))
