import sys
input = sys.stdin.readline

def count_worm(field):
    count = 0  # 지렁이 카운터
    visited = [[False for _ in range(len(field[0]))] for _ in range(len(field))]  # 방문 여부 체크
    
    # 상하좌우 방향 (상, 하, 좌, 우)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def dfs(x, y):
        # 방문 처리
        visited[x][y] = True
        
        # 상하좌우로 배추가 있는 곳을 탐색
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            # 범위 안에 있고, 배추가 있고, 아직 방문하지 않았다면
            if 0 <= nx < len(field) and 0 <= ny < len(field[0]) and field[nx][ny] == 1 and not visited[nx][ny]:
                dfs(nx, ny)  # 재귀적으로 탐색

    for row in range(len(field)):
        for col in range(len(field[0])):
            if field[row][col] == 1 and not visited[row][col]:
                dfs(row, col)  # 새로운 지렁이가 필요한 배추를 찾으면 DFS 시작
                count += 1  # 새로운 지렁이 발견

    print(count)
    return count

def print_field(field):
    for row in field:
        print(row)

t = int(input())  # 테스트 케이스 수

for _ in range(t):
    x, y, p = map(int, input().split())  # x: 밭 가로, y: 밭 세로, p: 배추 수
    field = [[0 for _ in range(x)] for _ in range(y)]

    for i in range(p):
        m, n = map(int, input().split())
        if 0 <= m < x and 0 <= n < y:  # 인덱스 범위 체크
            field[n][m] = 1  # 배추 위치
        else:
            print(f"잘못된 배추 위치: ({m}, {n})")  # 오류 처리

    print_field(field)  # 필드 출력
    count_worm(field)  # 지렁이 수 출력
