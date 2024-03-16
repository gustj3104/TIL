'''세자리수*세자리수 값 출력하기'''
a=int(input())
b=int(input())
c=((b%100)%10)*a
print(c)
d=((b%100)//10)*a
print(d)
e=(b//100)*a
print(e)
f=e*100+d*10+c
print(f)