''' 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하기'''
N=int(input())
a=list(map(int, input().split()))
v=int(input())
k=0
for i in range(N):
    if a[i]==v:
        k+=1
print(k)
