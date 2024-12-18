import sys
input = sys.stdin.readline

def count_worm(field):
    count = 0  # 지렁이 카운터
    visited = [[False for _ in range(len(field[0]))] for _ in range(len(field))]  # 방문 여부 체크
    
    # 상하좌우 방향 (상, 하, 좌, 우)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def iterative_dfs(x, y):
        stack = [(x, y)]  # 스택을 사용하여 DFS 탐색
        visited[x][y] = True
        
        while stack:
            cx, cy = stack.pop()  # 스택에서 하나의 요소를 꺼냄
            # 상하좌우로 배추가 있는 곳을 탐색
            for dx, dy in directions:
                nx, ny = cx + dx, cy + dy
                # 범위 안에 있고, 배추가 있고, 아직 방문하지 않았다면
                if 0 <= nx < len(field) and 0 <= ny < len(field[0]) and field[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    stack.append((nx, ny))  # 새로운 배추를 스택에 추가

    for row in range(len(field)):
        for col in range(len(field[0])):
            if field[row][col] == 1 and not visited[row][col]:
                iterative_dfs(row, col)  # 새로운 지렁이가 필요한 배추를 찾으면 DFS 시작
                count += 1  # 새로운 지렁이 발견

    print(count)
    return count

t = int(input())  # 테스트 케이스 수

for _ in range(t):
    x, y, p = map(int, input().split())  # x: 밭 가로, y: 밭 세로, p: 배추 수
    field = [[0 for _ in range(x)] for _ in range(y)]

    for i in range(p):
        m, n = map(int, input().split())
        if 0 <= m < x and 0 <= n < y:  # 인덱스 범위 체크
            field[n][m] = 1  # 배추 위치

    count_worm(field)  # 지렁이 수 출력
