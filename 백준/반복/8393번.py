'''n이 주어졌을 때, 1부터 n까지 합 구하기'''
n=int(input())
s=0
for i in range(1, n+1):
    s=i+s
print(s)