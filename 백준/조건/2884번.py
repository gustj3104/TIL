'''알람 45분 일찍 설정하기'''
h, m=map(int, input().split())
if (m-45)<0:
    m=m+60-45
    h=h-1
    if h<0:
        h=h+24
else:
    m=m-45
print(h, m)