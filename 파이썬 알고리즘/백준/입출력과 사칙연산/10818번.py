'''N개의 정수가 주어질 때, 최솟값과 최댓값 구하기'''
n=int(input())
a=[]
a=list(map(int, input().split()))
print(min(a), max(a))