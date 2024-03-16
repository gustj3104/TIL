'''문자열 S를 입력받은 후 각 문자를 R번 반복해 새 문자열 P를 만들어 출력하기'''
t=int(input())
b=[]
p=[]
for i in range(t):
    a, b=map(str, input().split())
    for x in range(len(b)):
        p.extend([b[x]*int(a)])
    for i in p:
        print(i, end= "")
    print()
    p=[]