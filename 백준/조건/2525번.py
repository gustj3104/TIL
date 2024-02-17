'''요리 시작시간, 필요시간이 주어졌을 때, 완성시간 출력하기'''
h, m=map(int, input().split())
p=int(input())
if (m+p)>=60:
    h=h+((m+p)//60)
    m=(m+p)-((m+p)//60*60)
    if h>=24:
        h=h-24
else:
    m=m+p
print(h, m)