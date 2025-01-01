import sys
from collections import deque
input = sys.stdin.readline
field = list()

# bfs 
def count():
    black_count = 0
    white_count = 0

    visited = [[False for _ in range(n)] for _ in range(m)]
    direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def bfs(x, y, team):
        queue = deque([(x, y)])
        visited[x][y] = True
        size = 0

        while queue:
            cx, cy = queue.popleft()
            size += 1
            for dx, dy in direction:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and field[nx][ny] == team:
                    visited[nx][ny] = True
                    queue.append((nx, ny))

        return size
    
    for row in range(m):
        for col in range(n):
            if not visited[row][col]:
                # 팀별 처리
                if field[row][col] == "B":
                    black_count += bfs(row, col, "B") ** 2
                elif field[row][col] == "W":
                    white_count += bfs(row, col, "W") ** 2


    print(white_count, black_count)
    return white_count, black_count

# 메인
n, m = map(int, input().split()) # n: 가로 m: 세로
for _ in range(m):
    s = list(input())
    s.pop() #개행문자 제거
    field.append(s) # 2차원 배열로 저장

count()