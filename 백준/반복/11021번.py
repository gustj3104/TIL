'''두 정수 A, B를 입력받아 A+B를 출력하기'''
t=int(input())
for i in range(t):
    a, b=map(int, input().split())
    print("Case #%d:" %(i+1), a+b)