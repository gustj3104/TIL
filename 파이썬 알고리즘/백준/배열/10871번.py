'''N개로 이루어진 수열A, 정수X가 주어진다. A에서 X보다 작은 수를 모두 출력하기'''
import sys
N, X=map(int, input().split())
A=list(map(int, input().split()))
for i in range(N):
    if(A[i]<X):
        print(A[i])