'''구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사하기'''
x=int(input())
n=int(input())
s=0
for i in range(n):
    a, b=map(int, input().split())
    s=a*b+s
if s==x:
    print("Yes")
else:
    print("No")