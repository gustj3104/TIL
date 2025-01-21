'''
입력 받아서 field 구성
요소가 2인 인덱스 구하기 -> start 지점
bfs 함수를 써서 안에 distance 항목 넣고, 저장하기
'''
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
field = []
for _ in range(n):
    s = list(map(int, input().split()))
    field.append(s)

# 2의 위치 찾기
# start = field.find(2) -> 2차원 배열에선 find 함수 사용 불가능
start = None
for i in range(n):
    for j in range(m):
        if field[i][j] == 2:
            start = (i, j)
            break
    if start:
        break

def bfs(start, graph):
    visited = [[False for _ in range(m)] for _ in range(n)]
    distance = [[-1 for _ in range(m)] for _ in range(n)]
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    queue = deque([start])
    visited[start[0]][start[1]] = True # 시작 지점을 True로 설정
    distance[start[0]][start[1]] = 0 # 시작 지점 거리는 0

    while queue:
        x, y = queue.popleft()
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] != 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                distance[nx][ny] = distance[x][y] + 1
                queue.append((nx, ny))
        
    for row in range(n):
        for col in range(m):
            if graph[row][col] == 0:
                distance[row][col] = 0

    for row in distance:
        print(" ".join(map(str, row)))
    
    
bfs(start, field)