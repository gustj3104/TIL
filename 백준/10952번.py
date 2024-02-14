'''두 정수 A, B를 입력받은 후 A+B 출력'''
N=100
A=1
B=1
while(A!=0 and B!=0):
    A, B=map(int, input().split())
    if(A+B==0):
        A=0
    else:
        print(A+B)