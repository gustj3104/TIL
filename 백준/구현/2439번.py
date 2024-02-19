'''별 n개 출력하여 오른쪽 정렬하기'''
n=int(input())
for i in range(1, n+1):
    a="*"*i
    print(a.rjust(n))