import sys
input = sys.stdin.readline

def calculate_prefix_sum(n, m, field):
    psum = [[0] * (m + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + field[i - 1][j - 1]
    return psum

def query_sum(psum, i, j, x, y):
    return psum[x][y] - psum[i - 1][y] - psum[x][j - 1] + psum[i - 1][j - 1]

n, m = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(n)]

psum = calculate_prefix_sum(n, m, field)

k = int(input())
for _ in range(k):
    i, j, x, y = map(int, input().split())
    print(query_sum(psum, i, j, x, y))
