'''N*M크기의 두 행렬을 더하기'''
a=[[]]
b=[[]]
c=[[]]
N, M=map(int, input().split())
a=[list(map(int, input().split())) for _ in range(N)]
b=[list(map(int, input().split())) for _ in range(N)]

c=[[0]*M for _ in range(N)]

for i in range(N):
    for x in range(M):
        c[i][x] = a[i][x]+b[i][x]
        print(c[i][x], end=" ")


