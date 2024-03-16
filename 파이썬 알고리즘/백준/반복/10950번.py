'''두 정수 A, B를 입력받은 다음 A+B를 출력하는 프로그램을 작성하시오'''

T=int(input())
a=[]
for i in range(1, T+1):
    A, B=map(int, input().split())
    a.append(A+B)
for i in a:
    print(i)

