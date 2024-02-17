'''6번째 자리에 들어가는 검증수 계산하기/검증수=고유번호 숫자 5개의 제곱한 수의 합을 10으로 나눈 나머지'''
a=[]
s=0
b=list(map(int, input().split()))
for i in range(len(b)):
    c=int(b[i]**2)
    a.append(c)
    s=s+a[i]
print(s%10)

