'''0보다 크거나 같은 정수 N이 주어진다. N! 출력'''

N=int(input())
P=1
for i in range(1, N+1):
    P = P*i
print(P)