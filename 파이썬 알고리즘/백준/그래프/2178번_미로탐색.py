import sys
from collections import deque
input = sys.stdin.readline
field = []

def find_route(field):
    visited = [[False for _ in range(m)] for _ in range(n)]
    direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def bfs(x, y):
        queue = deque([(x, y, 1)])  # xx, y, 거리
        visited[x][y] = True

        while queue:
            cx, cy, dist = queue.popleft()
            if cx == n - 1 and cy == m - 1:
                return dist  # (n-1, m-1)에 도달했을 때의 거리
            for dx, dy in direction:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and field[nx][ny] == 1:
                    visited[nx][ny] = True
                    queue.append((nx, ny, dist + 1))
        return -1 

    return bfs(0, 0)

# (0, 0)부터 (n-1, m-1)의 위치로 이동하는 최소 칸 수 구하기
n, m = map(int, input().split())
for i in range(n):
    x = list(map(int, input().strip()))
    field.append(x)

print(find_route(field))
