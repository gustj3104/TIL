'''주사위 3개를 던져서 받는 상금 계산하기
같은 눈 3개 = 10000+(같은 눈)*1000
같은 눈 2개 = 1000+(같은 눈)*100
다 다른 눈 = 가장 큰 눈 * 100'''
a, b, c=map(int, input().split())
if a==b==c:
    s=10000+(a*1000)
elif (a==b and a!=c):
    s=1000+(a*100)
elif (b==c and a!=b) :
    s=1000+(b*100)
elif (a==c and a!=b):
    s=1000+(a*100)
else:
    if a>b and a>c:
        s=a*100
    elif b>a and b>c:
        s=b*100
    else:
        s=c*100
print(s)