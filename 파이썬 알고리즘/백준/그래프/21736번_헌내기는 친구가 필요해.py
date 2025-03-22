'''
이동 방법 -> 상하좌우로
만날 수 있는 사람 수 구하기

O: 빈 공간
X: 벽
I: 도연이
P: 사람람
'''
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
campus = []
x, y = -1, -1

for i in range(N):
    c = list(input().strip())
    if "I" in c:
        x = i
        y = c.index("I")
    campus.append(c)

count = 0 # 친구 수

def find_friend(x, y):
    queue = deque([(x, y)])
    visited = [[False] * M for _ in range(N)]
    visited[x][y] = True
    count = 0

    direction = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while queue:
        cx, cy = queue.popleft()
        
        for dx, dy in direction:
            nx, ny = cx + dx, cy + dy
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and campus[nx][ny] != "X":
                visited[nx][ny] = True
                queue.append((nx, ny))
                if campus[nx][ny] == "P":
                    count += 1
    return count

result = find_friend(x, y)
print(result if result > 0 else "TT")