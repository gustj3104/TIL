import sys
from collections import defaultdict
input = sys.stdin.readline

def bfs(field):
    n = len(field)
    count = 0  # 단지 수
    result = defaultdict(int)
    visited = [[False for _ in range(n)] for _ in range(n)]  # 방문 여부 체크
    
    # 상하좌우 방향 (상, 하, 좌, 우)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def iterative_dfs(x, y):
        stack = [(x, y)]
        visited[x][y] = True
        result[count] = 1  # 현재 단지에 첫 집 포함

        while stack:
            cx, cy = stack.pop()
            for dx, dy in directions:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < n and 0 <= ny < n and field[nx][ny] == 1 and not visited[nx][ny]:
                    result[count] += 1
                    visited[nx][ny] = True
                    stack.append((nx, ny))

    for row in range(n):
        for col in range(n):
            if field[row][col] == 1 and not visited[row][col]:
                iterative_dfs(row, col)
                count += 1
    
    print(count)
    for i in sorted(result.values()):
        print(i)

n = int(input())
field = [list(map(int, input().strip())) for _ in range(n)]

bfs(field)
