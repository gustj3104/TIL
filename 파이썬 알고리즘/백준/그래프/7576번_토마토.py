from collections import deque
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
field = [list(map(int, input().split())) for _ in range(n)]

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs():
    queue = deque()
    total_days = 0

    for row in range(n):
        for col in range(m):
            if field[row][col] == 1:
                queue.append((row, col, 0))
    
    while queue:
        x, y, days = queue.popleft()
        total_days = max(total_days, days)

        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and field[nx][ny] == 0:
                field[nx][ny] = 1
                queue.append((nx, ny, days + 1))

    for row in field:
        if 0 in row:
            return -1

    return total_days

print(bfs())